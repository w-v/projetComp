/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libclass)            *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                     *
 *            ADILI ROBIN - LEBOULANGER HUGUES - TOMAS PABLI                     *
 *                                                                               *
 *                                                                               *
 *   nom du programme compile, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valNb = valeur du dernier nombre entier lu (item nbentier)    *
 *     int UtilLex.numId = code du dernier identificateur lu (item ident)        *
 *                                                                               *
 *                                                                               *
 *   methodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arret compilation       *
 *     String UtilLex.repId(int nId) delivre l'ident de codage nId               *
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/


import java.io.*;

// classe de mise en oeuvre du compilateur
// =======================================
// (verifications semantiques + production du code objet)

public class PtGen {


	// constantes manipulees par le compilateur
	// ----------------------------------------

	private static final int 

	// taille max de la table des symboles
	MAXSYMB=300,

	// codes MAPILE :
	RESERVER=1,EMPILER=2,CONTENUG=3,AFFECTERG=4,OU=5,ET=6,NON=7,INF=8,
	INFEG=9,SUP=10,SUPEG=11,EG=12,DIFF=13,ADD=14,SOUS=15,MUL=16,DIV=17,
	BSIFAUX=18,BINCOND=19,LIRENT=20,LIREBOOL=21,ECRENT=22,ECRBOOL=23,
	ARRET=24,EMPILERADG=25,EMPILERADL=26,CONTENUL=27,AFFECTERL=28,
	APPEL=29,RETOUR=30,

	// codes des valeurs vrai/faux
	VRAI=1, FAUX=0,

	// types permis :
	ENT=1,BOOL=2,NEUTRE=3,

	// cat�gories possibles des identificateurs :
	CONSTANTE=1,VARGLOBALE=2,VARLOCALE=3,PARAMFIXE=4,PARAMMOD=5,PROC=6,
	DEF=7,REF=8,PRIVEE=9,

	//valeurs possible du vecteur de translation 
	TRANSDON=1,TRANSCODE=2,REFEXT=3;


	// utilitaires de controle de type
	// -------------------------------

	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}

	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

	// pile pour gerer les chaines de reprise et les branchements en avant
	// -------------------------------------------------------------------

	private static TPileRep pileRep;  


	// production du code objet en memoire
	// -----------------------------------

	private static ProgObjet po;


	// COMPILATION SEPAREE 
	// -------------------
	//
	// modification du vecteur de translation associe au code produit 
	// + incrementation attribut nbTransExt du descripteur
	// NB: effectue uniquement si c'est une reference externe ou si on compile un module
	private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}

	// descripteur associe a un programme objet
	private static Descripteur desc;


	// autres variables fournies
	// -------------------------
	public static String trinome="ADILI_LEBOULANGER_TOMAS"; // MERCI de renseigner ici un nom pour le trinome, constitue de exclusivement de lettres

	private static int tCour; // type de l'expression compilee
	private static int vCour; // valeur de l'expression compilee le cas echeant


	// D�finition de la table des symboles
	//
	private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];

	// it = indice de remplissage de tabSymb
	// bc = bloc courant (=1 si le bloc courant est le programme principal)
	private static int it, bc;

	// utilitaire de recherche de l'ident courant (ayant pour code UtilLex.numId) dans tabSymb
	// rend en resultat l'indice de cet ident dans tabSymb (O si absence)
	private static int presentIdent(int binf) {
		int i = it;
		while (i >= binf && tabSymb[i].code != UtilLex.numId)
			i--;
		if (i >= binf)
			return i;
		else
			return 0;
	}

	// utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	//
	private static void placeIdent(int c, int cat, int t, int v) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(c, cat, t, v);
	}

	// utilitaire d'affichage de la table des symboles
	//
	private static void afftabSymb() { 
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" référence NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}


	// initialisations A COMPLETER SI BESOIN
	// -------------------------------------

	private static int vTmp;
	private static int nbVar;
	private static int nbParamProc;

	public static void initialisations() {

		// indices de gestion de la table des symboles
		it = 0;
		bc = 1;

		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep(); 
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();

		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();

		// initialisation du type de l'expression courante
		tCour = NEUTRE;

		//Initialisation de la variable qui compte le nombre de param�tres de chaque proc�dure 
		nbParamProc = 0;

		//Initialisation de la variable qui compte le nombre de variables d�clar�es
		nbVar++;

		//Initialisation vTmp
		vTmp = 0;
		
		desc.setUnite("programme");
		
	} // initialisations


	// code des points de generation A COMPLETER
	// -----------------------------------------
	public static void pt(int numGen) {

		switch (numGen) {
		case 0:
			initialisations();
			break;

			/* Primaires et Valeurs */

		case 1: //Valeur NBENTIER POS
			tCour = ENT; 
			vCour = UtilLex.valNb;
			break;
		case 2: //Valeur NBENTIER NEG
			tCour = ENT; 
			vCour = -UtilLex.valNb;
			break;
		case 3: //Valeur BOOL VRAI
			tCour = BOOL; 
			vCour = 1;
			break;
		case 4: //Valeur BOOL FAUX
			tCour = BOOL; 
			vCour = 0;
			break;

		case 5: //PRIMAIRE VALEUR
			po.produire(EMPILER);
			po.produire(vCour);
			break;
		case 6 : //PRIMAIRE IDENT
			int valALire = presentIdent(1);
			if(valALire == 0) UtilLex.messErr("La variable n'existe pas");
			else {
				switch (tabSymb[valALire].categorie) {
				case CONSTANTE:
					po.produire(EMPILER);
					po.produire(tabSymb[valALire].info);
					break;

				case VARGLOBALE:
					po.produire(CONTENUG);
					po.produire(tabSymb[valALire].info);
					if( desc.getUnite().equals("module") )
						modifVecteurTrans(1);
					break;

				case VARLOCALE: 
					po.produire(CONTENUL);
					po.produire(tabSymb[valALire].info);
					po.produire(0);
					break;

				case PARAMFIXE : 
					po.produire(CONTENUL);
					po.produire(tabSymb[valALire].info);
					po.produire(0);
					break;

				case PARAMMOD : 
					po.produire(CONTENUL);
					po.produire(tabSymb[valALire].info);
					po.produire(1);
					break;

				default:
					UtilLex.messErr("Action non valide");
					break;
				}
			}
			tCour = tabSymb[valALire].type;
			break;

			/* Expressions */

		case 10:
			verifBool();
			break;
		case 11:
			po.produire(OU);
			tCour = BOOL;
			break;
		case 12:
			po.produire(ET);
			tCour = BOOL;
			break;
		case 13:
			po.produire(NON);
			tCour = BOOL;
			break;
		case 14:
			verifEnt();
			break;
		case 15:
			po.produire(EG);
			break;
		case 16:
			po.produire(DIFF);
			break;
		case 17:
			po.produire(SUP);
			break;
		case 18:
			po.produire(SUPEG);
			break;
		case 19:
			po.produire(INF);
			break;
		case 20:
			po.produire(INFEG);
			break;
		case 21:
			po.produire(ADD);
			tCour = ENT;
			break;
		case 22:
			po.produire(SOUS);
			tCour = ENT;
			break;
		case 23:
			po.produire(MUL);
			tCour = ENT;
			break;
		case 24:
			po.produire(DIV);
			tCour = ENT;
			break;
		case 25:
			tCour = BOOL;
			break;

			/* Déclarations */

			// Variables
		case 50:
			tCour = ENT;
			break;

		case 51:
			tCour = BOOL;
			break;

		case 52:
			nbVar = 0;
			break;

		case 53: //On place l'ident dans la table des symboles
			int varc = presentIdent(1);
			if( varc == 0) {
				//dernier ident lu n'est pas dans tabSymb
				if(bc == 1){
					placeIdent(UtilLex.numId, VARGLOBALE, tCour, nbVar);
				}
				else{
					placeIdent(UtilLex.numId, VARLOCALE, tCour, nbVar+nbParamProc+2);
				}
				nbVar++;
			}
			else {
				UtilLex.messErr("La variable '"+UtilLex.repId(varc)+"' a deja ete declaree");
			}
			break;

		case 54: //On reserve de l'espace pour chaque variable globale/locale lue
			if( desc.getUnite().equals("programme") ){
				po.produire(RESERVER);
				po.produire(nbVar);
			}
			desc.setTailleGlobaux(nbVar);
			break;

			// Constantes

		case 60: //"Var = valeur", On place var dans la table des symboles
			int constc = presentIdent(1);
			if( constc == 0) {
				//dernier ident lu n'est pas dans tabSymb
				placeIdent(UtilLex.numId, CONSTANTE, tCour, vCour);

			}
			else {
				UtilLex.messErr("La constante '"+UtilLex.repId(constc)+"' a deja ete declaree");
			}

			break;


			/* Affectations */

		case 70:
			vTmp = presentIdent(1);
			break;

		case 71:
			int varAffect = vTmp;
			if( varAffect == 0) {
				//dernier ident lu n'est pas dans tabSymb
				UtilLex.messErr("La Variable '"+UtilLex.repId(varAffect)+"' n'a pas ete declaree");
			}
			else {
				if(tabSymb[varAffect].type != tCour) {
					UtilLex.messErr("types non-concordants");
				}
				switch(tabSymb[varAffect].categorie){
				case VARGLOBALE : 
					po.produire(AFFECTERG);
					po.produire(tabSymb[varAffect].info);
					if( desc.getUnite().equals("module") )
						modifVecteurTrans(1);
					break;
				case VARLOCALE : 
					po.produire(AFFECTERL);
					po.produire(tabSymb[varAffect].info);
					po.produire(0);
					break;
				case PARAMMOD :
					po.produire(AFFECTERL);
					po.produire(tabSymb[varAffect].info);
					po.produire(1);					
					break;				
				default : 
					UtilLex.messErr("Ne peut pas affecter dans "+UtilLex.repId(varAffect)+"', c'est une constante");
					break;
				}
			}

			break;


			/* Lectures, Ecritures */

			// Lecture

		case 80:
			int varALire = presentIdent(1);
			if( varALire == 0) {
				//dernier ident lu n'est pas dans tabSymb
				UtilLex.messErr(UtilLex.repId(varALire)+"' n'a pas ete declaree");
			}			
			switch(tabSymb[varALire].categorie){
			case VARGLOBALE : 
				if(tabSymb[varALire].type == BOOL){
					po.produire(LIREBOOL);
				} else {
					po.produire(LIRENT);
				}
				po.produire(AFFECTERG);
				po.produire(tabSymb[varALire].info);
				if( desc.getUnite().equals("module") )
					modifVecteurTrans(1);
				break;
			case VARLOCALE : 
				if(tabSymb[varALire].type == BOOL){
					po.produire(LIREBOOL);
				} else {
					po.produire(LIRENT);	
				}
				po.produire(AFFECTERL);
				po.produire(tabSymb[varALire].info);
				po.produire(0);
				break;
			case PARAMMOD :
				if(tabSymb[varALire].type == BOOL){
					po.produire(LIREBOOL);
				} else {
					po.produire(LIRENT);
				}
				po.produire(AFFECTERG);
				po.produire(tabSymb[varALire].info);
				po.produire(1);
				if( desc.getUnite().equals("module") )
					modifVecteurTrans(1);
				break;				
			default : 
				UtilLex.messErr("Ne peut pas lire dans "+UtilLex.repId(varALire)+"', c'est une constante");
				break;
			}
			break;

			// Ecriture

		case 81:
			switch(tCour) {
			case BOOL:
				po.produire(ECRBOOL);
				break;
			case ENT:
				po.produire(ECRENT);
				break;
			}
			break;

			/* Conditions */

			/* si */

			// si
		case 100:
			verifBool();
			po.produire(BSIFAUX);
			//on met 0 en argument en attendant de savoir ou on branche
			po.produire(0);
			pileRep.empiler(po.getIpo());
			if( desc.getUnite().equals("module") )
				modifVecteurTrans(2);
			break;

			// sinon
		case 101:
			po.modifier(pileRep.depiler(), po.getIpo()+3);
			po.produire(BINCOND);
			//on met 0 en argument en attendant de savoir ou on branche
			po.produire(0);
			pileRep.empiler(po.getIpo());
			if( desc.getUnite().equals("module") )
				modifVecteurTrans(2);
			break;

			// fsi
		case 102:
			po.modifier(pileRep.depiler(), po.getIpo()+1);
			break;

			/* cond */

			// cond
		case 120:
			pileRep.empiler(0);
			break;

			// exp : (bsifaux)
		case 121:
			verifBool();
			po.produire(BSIFAUX);
			//on met 0 en argument en attendant de savoir ou on branche
			po.produire(0);
			pileRep.empiler(po.getIpo());
			if( desc.getUnite().equals("module") )
				modifVecteurTrans(2);
			//System.out.println("121 "+pileRep.toString());
			break;

			// , ou aut (bincond)
		case 122:
			po.modifier(pileRep.depiler(), po.getIpo()+3);
			//System.out.println("122_1 "+pileRep.toString());
			po.produire(BINCOND);
			po.produire(pileRep.depiler());
			pileRep.empiler(po.getIpo());
			if( desc.getUnite().equals("module") )
				modifVecteurTrans(2);
			//System.out.println("122_2 "+pileRep.toString());
			break;

			// fcond
		case 123:
			int fcond = po.getIpo()+1;
			// last binc (-1)
			int lbinc = pileRep.depiler();
			// the one before (-2)
			int tmp;

			while(lbinc != 0) {				// 0 n'est jamais dans la pile à fcond, ce while fait toujours au moins une iteration
				tmp = po.getElt(lbinc);
				po.modifier(lbinc, fcond);
				lbinc = tmp;
			}
			break;

			// cas ou il n'y a pas de aut
			// 	-> regler le dernier bsifaux a ipo+1
			//	-> ne pas produire de bincond pour le dernier case
		case 124:
			po.modifier(pileRep.depiler(), po.getIpo()+1);
			break;

			/* Boucle */

			// ttq
		case 140:
			pileRep.empiler(po.getIpo()+1);
			break;

			// exp
		case 141:
			verifBool();
			po.produire(BSIFAUX);
			//on met 0 en argument en attendant de savoir ou on branche
			po.produire(0);
			pileRep.empiler(po.getIpo());
			if( desc.getUnite().equals("module") )
				modifVecteurTrans(2);
			break;

		case 142:
			po.modifier(pileRep.depiler(), po.getIpo()+3);
			po.produire(BINCOND);
			po.produire(pileRep.depiler());
			if( desc.getUnite().equals("module") )
				modifVecteurTrans(2);
			break;

			/////////////// PROCEDURES /////////////////// 

			//Si il ya des proc�dures
		case 198 : 
			if( desc.getUnite().equals("programme") ){
				po.produire(BINCOND);
				po.produire(0);
				pileRep.empiler(po.getIpo());
			}
			break;

		case 199 :
			if( desc.getUnite().equals("programme") ){
				po.modifier(pileRep.depiler(), po.getIpo()+1);
			}
			break;

		case 200 : //D�claration d'une proc�dure 

			//On v�ifie que le nom de la proc�dure n'est pas d�j� pris 
			if(presentIdent(1) == 0){
				placeIdent(UtilLex.numId, PROC, NEUTRE, po.getIpo()+1);
				int indexTabDef = desc.presentDef(UtilLex.repId(UtilLex.numId));
				if( indexTabDef != -1){
					desc.modifDefAdPo(indexTabDef, po.getIpo()+1);
					placeIdent(-1, DEF, NEUTRE, 0);
				}
				else{
					placeIdent(-1, PRIVEE, NEUTRE, 0);					
				}
				nbParamProc = 0;
			}
			bc = it + 1;
			break;



		case 201 : //D�claration des param�tres fixes
			//Ajout des param�tres fixes dans la table des symboles
			if(presentIdent(bc) == 0){
				placeIdent(UtilLex.numId, PARAMFIXE, tCour, nbParamProc);
				nbParamProc++;
			}
			break;

		case 202: //D�claration des param�tres mod
			if(presentIdent(bc) == 0){
				placeIdent(UtilLex.numId, PARAMMOD, tCour, nbParamProc);
				nbParamProc++;
			}
			break;

		case 203: //Modifie le nombre de param�tres dans la table des symboles 
			int indexTabDef = desc.presentDef(UtilLex.repId(tabSymb[bc-2].code));
			if( indexTabDef != -1)
				desc.modifDefNbParam(indexTabDef, nbParamProc);
			tabSymb[bc-1].info = nbParamProc;
			break;	

		case 210: 
			//Met � -1 les variables de la proc�dure une fois qu'elle est finie
			po.produire(RETOUR);
			po.produire(nbParamProc);
			it = bc + nbParamProc - 1;
			for(int i = 0; i < nbParamProc; i++){
				tabSymb[bc+i].code = -1;
			}			
			bc = 1;
			break;

			// appel d'une fonction
		case 215: 
			int paramEff = presentIdent(1);
			switch(tabSymb[paramEff].categorie){
			case VARGLOBALE : 
				po.produire(EMPILERADG);
				po.produire(tabSymb[paramEff].info);
				if( desc.getUnite().equals("module") )
					modifVecteurTrans(1);
				break;

			case VARLOCALE :
				po.produire(EMPILERADL);
				po.produire(tabSymb[paramEff].info);
				po.produire(0);
				break;

			case PARAMMOD :
				po.produire(EMPILERADL);
				po.produire(tabSymb[paramEff].info);
				po.produire(1);
				break;

			case PARAMFIXE :		
			case CONSTANTE : 
				UtilLex.messErr("PARAMFIXE et CONSTANTE interdits pour des PARAMMOD");
				break;

			}
			break;


		case 220 : 
			po.produire(APPEL); //On produit l'appel	
			po.produire(tabSymb[vTmp].info); //On produit le numero de la ligne de la proc
			if(desc.getUnite().equals("programme")){
				modifVecteurTrans(REFEXT);				
			}
			po.produire(tabSymb[vTmp+1].info); //On produit le nombre de paramètres de la proc
			break;

		/////////////// COMPILATION SEPAREE ///////////// 
		case 300: 
			//On lit un def, ajout du nom dans tabDef
			desc.ajoutDef(UtilLex.repId(UtilLex.numId));			
			break;
			
			// ajout du champs unite du descripteur
			
		case 301:
			desc.setUnite("programme");
			break;
		
		case 302:
			desc.setUnite("module");
			break;
		
		case 303:
			UtilLex.nomSource = UtilLex.repId(UtilLex.numId);
			break;
			
			// ajout de la taille du code
		case 304:
			desc.setTailleCode(po.getIpo());
			desc.ecrireDesc(UtilLex.nomSource);
			afftabSymb();
			System.out.println(desc);
			po.constGen();
			po.constObj();
			break;
			
			
			
		// taille 
		case 310:
			//On ajoute ref dans la table des symbs
			if(desc.presentRef(UtilLex.repId(UtilLex.numId)) == 0){
				desc.ajoutRef(UtilLex.repId(UtilLex.numId));
				desc.modifRefNbParam(desc.getNbRef(), 0);
				placeIdent(UtilLex.numId, PROC, NEUTRE, desc.getNbRef());
				placeIdent(-1, REF, NEUTRE, 0);
				nbParamProc = 0;
			}
			else{
				UtilLex.messErr("Procédure déjà declarée");
			}
			break;
		
		case 311:
			int i = desc.getNbRef();
			desc.modifRefNbParam(i, desc.getRefNbParam(i)+1);
			tabSymb[it].info = desc.getRefNbParam(i);
			break;
			

		case 312 : //D�claration des param�tres fixes
			//Ajout des param�tres fixes dans la table des symboles
			placeIdent(-1, PARAMFIXE, tCour, nbParamProc);
			nbParamProc++;
			break;

		case 313: //D�claration des param�tres mod
			placeIdent(-1, PARAMMOD, tCour, nbParamProc);
			nbParamProc++;
			break;

		case 314 : //Modifie le nombre de param�tres dans la table des symboles 
			tabSymb[it-nbParamProc].info = nbParamProc;
			break;	
			
		case 1000:
			po.produire(ARRET);
			break;

		default:
			System.out.println("Point de generation non prevu dans votre liste");
			break;

		}
	}

}













