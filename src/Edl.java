import java.io.*;
import java.util.List;
import java.util.ArrayList;
import org.omg.PortableServer.POAOperations;


public class Edl {
	
	// nombre max de modules, taille max d'un code objet d'une unite
	static final int MAXMOD = 5, MAXOBJ = 1000;
	// nombres max de references externes (REF) et de points d'entree (DEF)
	// pour une unite
	private static final int MAXREF = 10, MAXDEF = 10;
	
	// typologie des erreurs
	private static final int FATALE = 0, NONFATALE = 1;
	
	// valeurs possibles du vecteur de translation
	private static final int TRANSDON=1,TRANSCODE=2,REFEXT=3;
	
	// table de tous les descripteurs concernes par l'edl
	static Descripteur[] tabDesc = new Descripteur[MAXMOD + 1];
	
	// declarations de variables A COMPLETER SI BESOIN
	static int ipo, nMod, nbErr;
	static String nomProg;
	
	//Nos variables
	static int[] transDon = new int[MAXMOD];
	static int[] transCode = new int[MAXMOD];	
	static DicoDefElt[] dicoDef = new DicoDefElt[1+MAXREF*(MAXMOD+1)];
	static int[][] adFinal = new int[MAXMOD+1][MAXREF+1];
	static String[] nomUnite = new String[MAXMOD+1];

	// utilitaire de traitement des erreurs
	// ------------------------------------
	static void erreur(int te, String m) {
		System.out.println(m);
		if (te == FATALE) {
			System.out.println("ABANDON DE L'EDITION DE LIENS");
			System.exit(1);
		}
		nbErr = nbErr + 1;
	}

	// utilitaire de remplissage de la table des descripteurs tabDesc
	// --------------------------------------------------------------
	static void lireDescripteurs() {
		String s;
		System.out.println("les noms doivent etre fournis sans suffixe");
		System.out.print("nom du programme : ");
		s = Lecture.lireString();
		tabDesc[0] = new Descripteur();
		tabDesc[0].lireDesc(s);
		if (!tabDesc[0].getUnite().equals("programme"))
			erreur(FATALE, "programme attendu");
		nomProg = s;
		nomUnite[0] = s;					// on récupère le nom du programme
		
		nMod = 0;
		while (!s.equals("") && nMod < MAXMOD) {
			System.out.print("nom de module " + (nMod + 1)
					+ " (RC si termine) ");
			s = Lecture.lireString();
			if (!s.equals("")) {
				nMod = nMod + 1;
				tabDesc[nMod] = new Descripteur();
				tabDesc[nMod].lireDesc(s);
				nomUnite[nMod] = s;								// on récupère les noms des modules
				if (!tabDesc[nMod].getUnite().equals("module"))
					erreur(FATALE, "module attendu");
			}
		}
	}

	
	static void constMap() {
		// f2 = fichier ex�cutable .map construit
		OutputStream f2 = Ecriture.ouvrir(nomProg + ".map");
		if (f2 == null)
			erreur(FATALE, "création du fichier " + nomProg
					+ ".map impossible");
		// pour construire le code concat�n� de toutes les unit�s
		int[] po = new int[(nMod + 1) * MAXOBJ + 1];
		int baseAdr;
		int relAdr;
		int ipo = 1;
		// 
// ... A COMPLETER ...
		InputStream in;
		List<TransExt> transExt = new ArrayList<TransExt>();
		for(int i = 0; i < nMod+1; i++) { 
			in = Lecture.ouvrir(nomUnite[i]+".obj");
			baseAdr = ipo-1;
			for (int t = 0; t < tabDesc[i].getNbTransExt(); t++) {
				// Recupere chaque couples
				System.out.println(transExt.toString());
				transExt.add(new TransExt(Lecture.lireInt(in),Lecture.lireInt(in)));
			}
			while (ipo < transCode[i]+tabDesc[i].getTailleCode()+1) {
				po[ipo] = Lecture.lireInt(in);
				System.out.println("po[ipo]: "+po[ipo]);
				ipo++;
			}
			for (int t = 0; t < tabDesc[i].getNbTransExt(); t++) {
				relAdr = baseAdr + transExt.get(t).ipo;
				System.out.println("i: "+i+" po: "+po[relAdr]+" addr: "+relAdr+" type: "+transExt.get(t).type);
				switch(transExt.get(t).type) {
				case TRANSDON:
					po[relAdr] += transDon[i];
					break;

				case TRANSCODE:
					po[relAdr] += transCode[i];
					break;

				case REFEXT:
					po[relAdr] = adFinal[i][po[relAdr]];
					break;
				}
			}
			transExt.clear();
			Lecture.fermer(in);
		}
		for(int i = 1; i < ipo; i++)
			Ecriture.ecrireStringln(f2, ""+po[i]);
		Ecriture.fermer(f2);
		// création du fichier en mnémonique correspondant
		Mnemo.creerFichier(ipo-1, po, nomProg + ".ima");
	}

	public static void main(String argv[]) {
		System.out.println("EDITEUR DE LIENS / PROJET LICENCE");
		System.out.println("---------------------------------");
		System.out.println("");
		nbErr = 0;
		
		// Phase 1 de l'edition de liens
		// -----------------------------
		lireDescripteurs();		// lecture des descripteurs a completer si besoin
// 
// ... A COMPLETER ...
		
		
		transDon[0] = 0;
		transCode[0] = 0;
		
		int k = 1;
		
		//On init transDon, transCode et dicoDef
		for(int i = 1; i < nMod+1; i++){
			transDon[i] = tabDesc[i-1].getTailleGlobaux() + transDon[i-1];
			transCode[i] = tabDesc[i-1].getTailleCode() + transCode[i-1];
			System.out.println("don: "+transDon[i]+" code: "+transCode[i]);
			for(int j = 1; j < tabDesc[i].getNbDef()+1; j++){
				if(presentDicoDef(tabDesc[i].getDefNomProc(j)) < 0){
					dicoDef[k] = new DicoDefElt();
					dicoDef[k].adPo = tabDesc[i].getDefAdPo(j) + transCode[i]; 
					dicoDef[k].nbParam = tabDesc[i].getDefNbParam(j); 
					dicoDef[k].nomProc = tabDesc[i].getDefNomProc(j);
					System.out.println(dicoDef[k].nomProc);
					System.out.println("i: "+i+" k: "+k+" "+dicoDef[k].toString());
					k++;
				}
				else{
					System.out.println("double définition : "+ tabDesc[i].getDefNomProc(j));
					nbErr++;
				}
			}
		}
		
		//On init adFinal
		for(int i = 0; i < nMod + 1; i++){
			for(int j = 1; j < tabDesc[i].getNbRef()+1; j++){
				int idNom = presentDicoDef(tabDesc[i].getRefNomProc(j));
				if(idNom >= 0){
					adFinal[i][j] = dicoDef[idNom].adPo;
					System.out.println("i: "+i+"j: "+j+" "+adFinal[i][j]);
				}
			}
			
		}
		
		
	
		//On applique pour les modules :
		
		//pour les globales : valeurs actuelle +  transDon de i
		//pour les bsifaux : on applique les transCode
	
		
		
		if (nbErr > 0) {
			System.out.println("programme ex�cutable non produit");
			System.exit(1);
		}
		
		// Phase 2 de l'edition de liens
		// -----------------------------
		constMap();				// a completer
		System.out.println("Edition de liens terminee");
	}
	
	public static class DicoDefElt{
		
		//Attributs 
		public String nomProc;
		public int adPo;
		public int nbParam;
		
		
		//Constructeur
		public DicoDefElt(){
			nomProc = "";
			adPo = 0;
			nbParam = 0;
			
		}				
		@Override
		public String toString() {
			
			return "("+nomProc+","+adPo+","+nbParam+")";
		}
	}
	
	public static class TransExt{
		
		//Attributs 
		public int ipo;
		public int type;
		
		
		//Constructeur
		public TransExt(){
			ipo = 0;
			type = 0;
			
		}				
		public TransExt(int ipo, int type){
			this.ipo = ipo;
			this.type = type;
		}
		@Override
		public String toString() {
			
			return "("+ipo+","+type+")";
		}
	}

	public static int presentDicoDef(String nom){
		for(int i = 1; dicoDef[i] != null && i < dicoDef.length; i++){
			if( (dicoDef[i].nomProc).equals(nom) ){
				return i;
			}
		}
		return -1;
	}
}
