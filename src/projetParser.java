// $ANTLR 3.5.2 src/projet.g 2018-04-04 20:13:10
           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "LIGNE", 
		"ML_COMMENT", "WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", 
		"';'", "'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", 
		"'bool'", "'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", 
		"'ent'", "'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", 
		"'fsi'", "'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int LIGNE=7;
	public static final int ML_COMMENT=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/projet.g"; }



	 
	// variables globales et methodes utiles a placer ici
	  



	// $ANTLR start "unite"
	// src/projet.g:39:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// src/projet.g:39:8: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==49) ) {
				alt1=1;
			}
			else if ( (LA1_0==45) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// src/projet.g:39:12: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite66);
					unitprog();
					state._fsp--;

					PtGen.pt(304);
					match(input,EOF,FOLLOW_EOF_in_unite71); 
					}
					break;
				case 2 :
					// src/projet.g:40:12: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite84);
					unitmodule();
					state._fsp--;

					PtGen.pt(304);
					match(input,EOF,FOLLOW_EOF_in_unite89); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// src/projet.g:43:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// src/projet.g:44:3: ( 'programme' ident ':' declarations corps )
			// src/projet.g:44:5: 'programme' ident ':' declarations corps
			{
			match(input,49,FOLLOW_49_in_unitprog104); 
			PtGen.pt(301);
			pushFollow(FOLLOW_ident_in_unitprog108);
			ident();
			state._fsp--;

			PtGen.pt(303);
			match(input,16,FOLLOW_16_in_unitprog111); 
			pushFollow(FOLLOW_declarations_in_unitprog120);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog129);
			corps();
			state._fsp--;

			PtGen.pt(1000);
			 System.out.println("succes, arret de la compilation "); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// src/projet.g:49:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// src/projet.g:50:3: ( 'module' ident ':' declarations )
			// src/projet.g:50:5: 'module' ident ':' declarations
			{
			match(input,45,FOLLOW_45_in_unitmodule150); 
			PtGen.pt(302);
			pushFollow(FOLLOW_ident_in_unitmodule154);
			ident();
			state._fsp--;

			PtGen.pt(303);
			match(input,16,FOLLOW_16_in_unitmodule158); 
			pushFollow(FOLLOW_declarations_in_unitmodule166);
			declarations();
			state._fsp--;

			 System.out.println("succes, arret de la compilation "); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// src/projet.g:54:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// src/projet.g:55:3: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// src/projet.g:55:5: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// src/projet.g:55:5: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==31) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/projet.g:55:5: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations183);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// src/projet.g:55:16: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==50) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/projet.g:55:16: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations186);
					partieref();
					state._fsp--;

					}
					break;

			}

			// src/projet.g:55:27: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==29) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/projet.g:55:27: consts
					{
					pushFollow(FOLLOW_consts_in_declarations189);
					consts();
					state._fsp--;

					}
					break;

			}

			// src/projet.g:55:35: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==54) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/projet.g:55:35: vars
					{
					pushFollow(FOLLOW_vars_in_declarations192);
					vars();
					state._fsp--;

					}
					break;

			}

			// src/projet.g:55:41: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==48) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/projet.g:55:41: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations195);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// src/projet.g:58:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// src/projet.g:59:3: ( 'def' ident ( ',' ident )* ptvg )
			// src/projet.g:59:5: 'def' ident ( ',' ident )* ptvg
			{
			match(input,31,FOLLOW_31_in_partiedef212); 
			pushFollow(FOLLOW_ident_in_partiedef214);
			ident();
			state._fsp--;

			PtGen.pt(300);
			// src/projet.g:59:34: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/projet.g:59:35: ',' ident
					{
					match(input,14,FOLLOW_14_in_partiedef219); 
					pushFollow(FOLLOW_ident_in_partiedef221);
					ident();
					state._fsp--;

					PtGen.pt(300);
					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef227);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// src/projet.g:62:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// src/projet.g:62:10: ( 'ref' specif ( ',' specif )* ptvg )
			// src/projet.g:62:12: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,50,FOLLOW_50_in_partieref239); 
			pushFollow(FOLLOW_specif_in_partieref242);
			specif();
			state._fsp--;

			PtGen.pt(314);
			// src/projet.g:62:43: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/projet.g:62:44: ',' specif
					{
					match(input,14,FOLLOW_14_in_partieref247); 
					pushFollow(FOLLOW_specif_in_partieref249);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref253);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// src/projet.g:65:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// src/projet.g:65:9: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// src/projet.g:65:11: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif267);
			ident();
			state._fsp--;

			PtGen.pt(310);
			// src/projet.g:66:6: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==41) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// src/projet.g:66:8: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,41,FOLLOW_41_in_specif279); 
					match(input,10,FOLLOW_10_in_specif281); 
					pushFollow(FOLLOW_type_in_specif283);
					type();
					state._fsp--;

					PtGen.pt(311);
					PtGen.pt(312);
					// src/projet.g:66:57: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==14) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// src/projet.g:66:59: ',' type
							{
							match(input,14,FOLLOW_14_in_specif290); 
							pushFollow(FOLLOW_type_in_specif292);
							type();
							state._fsp--;

							PtGen.pt(311);
							PtGen.pt(312);
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,11,FOLLOW_11_in_specif300); 
					}
					break;

			}

			// src/projet.g:67:18: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==44) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// src/projet.g:67:20: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,44,FOLLOW_44_in_specif325); 
					match(input,10,FOLLOW_10_in_specif328); 
					pushFollow(FOLLOW_type_in_specif330);
					type();
					state._fsp--;

					PtGen.pt(311);
					PtGen.pt(313);
					// src/projet.g:67:69: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==14) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// src/projet.g:67:71: ',' type
							{
							match(input,14,FOLLOW_14_in_specif337); 
							pushFollow(FOLLOW_type_in_specif339);
							type();
							state._fsp--;

							PtGen.pt(311);
							PtGen.pt(313);
							}
							break;

						default :
							break loop11;
						}
					}

					match(input,11,FOLLOW_11_in_specif347); 
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// src/projet.g:70:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// src/projet.g:70:9: ( 'const' ( ident '=' valeur ptvg )+ )
			// src/projet.g:70:11: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,29,FOLLOW_29_in_consts364); 
			// src/projet.g:70:20: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// src/projet.g:70:22: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts369);
					ident();
					state._fsp--;

					match(input,22,FOLLOW_22_in_consts372); 
					pushFollow(FOLLOW_valeur_in_consts374);
					valeur();
					state._fsp--;

					PtGen.pt(60);
					pushFollow(FOLLOW_ptvg_in_consts379);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// src/projet.g:73:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// src/projet.g:73:7: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// src/projet.g:73:9: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,54,FOLLOW_54_in_vars398); 
			PtGen.pt(52);
			// src/projet.g:73:31: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==27||LA15_0==34) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// src/projet.g:73:33: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars404);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars406);
					ident();
					state._fsp--;

					PtGen.pt(53);
					// src/projet.g:73:60: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==14) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// src/projet.g:73:62: ',' ident
							{
							match(input,14,FOLLOW_14_in_vars412); 
							pushFollow(FOLLOW_ident_in_vars415);
							ident();
							state._fsp--;

							PtGen.pt(53);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars423);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			PtGen.pt(54);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// src/projet.g:76:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// src/projet.g:76:7: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==34) ) {
				alt16=1;
			}
			else if ( (LA16_0==27) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// src/projet.g:76:9: 'ent'
					{
					match(input,34,FOLLOW_34_in_type443); 
					PtGen.pt(50);
					}
					break;
				case 2 :
					// src/projet.g:77:9: 'bool'
					{
					match(input,27,FOLLOW_27_in_type456); 
					PtGen.pt(51);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// src/projet.g:80:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// src/projet.g:80:9: ( ( decproc ptvg )+ )
			// src/projet.g:80:11: ( decproc ptvg )+
			{
			PtGen.pt(198);
			// src/projet.g:80:27: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==48) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// src/projet.g:80:28: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs472);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs474);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			PtGen.pt(199);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// src/projet.g:83:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// src/projet.g:83:9: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// src/projet.g:83:11: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,48,FOLLOW_48_in_decproc490); 
			pushFollow(FOLLOW_ident_in_decproc493);
			ident();
			state._fsp--;

			PtGen.pt(200);
			// src/projet.g:83:42: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==41) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// src/projet.g:83:42: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc497);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// src/projet.g:83:51: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==44) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// src/projet.g:83:51: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc500);
					parmod();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(203);
			// src/projet.g:83:76: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==29) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// src/projet.g:83:76: consts
					{
					pushFollow(FOLLOW_consts_in_decproc505);
					consts();
					state._fsp--;

					}
					break;

			}

			// src/projet.g:83:84: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==54) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// src/projet.g:83:84: vars
					{
					pushFollow(FOLLOW_vars_in_decproc508);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc511);
			corps();
			state._fsp--;

			PtGen.pt(210);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// src/projet.g:86:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// src/projet.g:86:7: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==18) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==27||(LA22_0 >= 29 && LA22_0 <= 30)||LA22_0==34||LA22_0==48||LA22_0==50||LA22_0==54) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// src/projet.g:86:9: ';'
					{
					match(input,18,FOLLOW_18_in_ptvg527); 
					}
					break;
				case 2 :
					// src/projet.g:88:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// src/projet.g:90:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// src/projet.g:90:7: ( 'debut' instructions 'fin' )
			// src/projet.g:90:9: 'debut' instructions 'fin'
			{
			match(input,30,FOLLOW_30_in_corps545); 
			pushFollow(FOLLOW_instructions_in_corps547);
			instructions();
			state._fsp--;

			match(input,40,FOLLOW_40_in_corps549); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// src/projet.g:93:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// src/projet.g:93:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// src/projet.g:93:10: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,41,FOLLOW_41_in_parfixe562); 
			match(input,10,FOLLOW_10_in_parfixe564); 
			pushFollow(FOLLOW_pf_in_parfixe566);
			pf();
			state._fsp--;

			// src/projet.g:93:24: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==18) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// src/projet.g:93:26: ';' pf
					{
					match(input,18,FOLLOW_18_in_parfixe570); 
					pushFollow(FOLLOW_pf_in_parfixe572);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,11,FOLLOW_11_in_parfixe576); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// src/projet.g:96:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// src/projet.g:96:5: ( type ident ( ',' ident )* )
			// src/projet.g:96:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf590);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf592);
			ident();
			state._fsp--;

			PtGen.pt(201);
			// src/projet.g:96:35: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==14) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// src/projet.g:96:37: ',' ident
					{
					match(input,14,FOLLOW_14_in_pf598); 
					pushFollow(FOLLOW_ident_in_pf600);
					ident();
					state._fsp--;

					PtGen.pt(201);
					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// src/projet.g:99:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// src/projet.g:99:9: ( 'mod' '(' pm ( ';' pm )* ')' )
			// src/projet.g:99:11: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,44,FOLLOW_44_in_parmod620); 
			match(input,10,FOLLOW_10_in_parmod622); 
			pushFollow(FOLLOW_pm_in_parmod624);
			pm();
			state._fsp--;

			// src/projet.g:99:24: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==18) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// src/projet.g:99:26: ';' pm
					{
					match(input,18,FOLLOW_18_in_parmod628); 
					pushFollow(FOLLOW_pm_in_parmod630);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,11,FOLLOW_11_in_parmod634); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// src/projet.g:102:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// src/projet.g:102:5: ( type ident ( ',' ident )* )
			// src/projet.g:102:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm648);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm650);
			ident();
			state._fsp--;

			PtGen.pt(202);
			// src/projet.g:102:35: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==14) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// src/projet.g:102:37: ',' ident
					{
					match(input,14,FOLLOW_14_in_pm656); 
					pushFollow(FOLLOW_ident_in_pm658);
					ident();
					state._fsp--;

					PtGen.pt(202);
					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// src/projet.g:105:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// src/projet.g:106:3: ( instruction ( ';' instruction )* )
			// src/projet.g:106:5: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions678);
			instruction();
			state._fsp--;

			// src/projet.g:106:17: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==18) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// src/projet.g:106:19: ';' instruction
					{
					match(input,18,FOLLOW_18_in_instructions682); 
					pushFollow(FOLLOW_instruction_in_instructions684);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// src/projet.g:109:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// src/projet.g:110:3: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt28=1;
				}
				break;
			case 28:
				{
				alt28=2;
				}
				break;
			case 53:
				{
				alt28=3;
				}
				break;
			case 43:
				{
				alt28=4;
				}
				break;
			case 33:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 14:
			case 18:
			case 26:
			case 37:
			case 39:
			case 40:
			case 42:
			case 52:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// src/projet.g:110:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction701);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// src/projet.g:111:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction707);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// src/projet.g:112:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction713);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// src/projet.g:113:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction719);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// src/projet.g:114:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction725);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// src/projet.g:115:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction731);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// src/projet.g:117:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// src/projet.g:119:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// src/projet.g:119:7: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// src/projet.g:119:9: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,51,FOLLOW_51_in_inssi748); 
			pushFollow(FOLLOW_expression_in_inssi750);
			expression();
			state._fsp--;

			PtGen.pt(100);
			match(input,25,FOLLOW_25_in_inssi754); 
			pushFollow(FOLLOW_instructions_in_inssi756);
			instructions();
			state._fsp--;

			// src/projet.g:119:63: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==52) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// src/projet.g:119:64: 'sinon' instructions
					{
					match(input,52,FOLLOW_52_in_inssi759); 
					PtGen.pt(101);
					pushFollow(FOLLOW_instructions_in_inssi764);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,42,FOLLOW_42_in_inssi768); 
			PtGen.pt(102);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// src/projet.g:122:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// src/projet.g:122:9: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// src/projet.g:122:11: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,28,FOLLOW_28_in_inscond783); 
			PtGen.pt(120);
			pushFollow(FOLLOW_expression_in_inscond788);
			expression();
			state._fsp--;

			PtGen.pt(121);
			match(input,16,FOLLOW_16_in_inscond792); 
			pushFollow(FOLLOW_instructions_in_inscond794);
			instructions();
			state._fsp--;

			// src/projet.g:123:11: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==14) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// src/projet.g:123:12: ',' expression ':' instructions
					{
					match(input,14,FOLLOW_14_in_inscond809); 
					PtGen.pt(122);
					pushFollow(FOLLOW_expression_in_inscond814);
					expression();
					state._fsp--;

					PtGen.pt(121);
					match(input,16,FOLLOW_16_in_inscond818); 
					pushFollow(FOLLOW_instructions_in_inscond820);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop30;
				}
			}

			// src/projet.g:124:11: ( 'aut' instructions |)
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==26) ) {
				alt31=1;
			}
			else if ( (LA31_0==39) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// src/projet.g:124:12: 'aut' instructions
					{
					match(input,26,FOLLOW_26_in_inscond837); 
					PtGen.pt(122);
					pushFollow(FOLLOW_instructions_in_inscond842);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// src/projet.g:124:51: 
					{
					PtGen.pt(124);
					}
					break;

			}

			match(input,39,FOLLOW_39_in_inscond861); 
			PtGen.pt(123);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// src/projet.g:128:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// src/projet.g:128:9: ( 'ttq' expression 'faire' instructions 'fait' )
			// src/projet.g:128:11: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,53,FOLLOW_53_in_boucle877); 
			PtGen.pt(140);
			pushFollow(FOLLOW_expression_in_boucle881);
			expression();
			state._fsp--;

			PtGen.pt(141);
			match(input,36,FOLLOW_36_in_boucle885); 
			pushFollow(FOLLOW_instructions_in_boucle887);
			instructions();
			state._fsp--;

			match(input,37,FOLLOW_37_in_boucle889); 
			PtGen.pt(142);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// src/projet.g:131:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// src/projet.g:131:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// src/projet.g:131:10: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,43,FOLLOW_43_in_lecture903); 
			match(input,10,FOLLOW_10_in_lecture905); 
			pushFollow(FOLLOW_ident_in_lecture907);
			ident();
			state._fsp--;

			PtGen.pt(80);
			// src/projet.g:131:43: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==14) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// src/projet.g:131:45: ',' ident
					{
					match(input,14,FOLLOW_14_in_lecture913); 
					pushFollow(FOLLOW_ident_in_lecture915);
					ident();
					state._fsp--;

					PtGen.pt(80);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,11,FOLLOW_11_in_lecture922); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// src/projet.g:134:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// src/projet.g:134:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// src/projet.g:134:11: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,33,FOLLOW_33_in_ecriture935); 
			match(input,10,FOLLOW_10_in_ecriture937); 
			pushFollow(FOLLOW_expression_in_ecriture939);
			expression();
			state._fsp--;

			PtGen.pt(81);
			// src/projet.g:134:52: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==14) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// src/projet.g:134:54: ',' expression
					{
					match(input,14,FOLLOW_14_in_ecriture946); 
					pushFollow(FOLLOW_expression_in_ecriture948);
					expression();
					state._fsp--;

					PtGen.pt(81);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,11,FOLLOW_11_in_ecriture955); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// src/projet.g:137:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// src/projet.g:138:3: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// src/projet.g:138:5: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel971);
			ident();
			state._fsp--;

			PtGen.pt(70);
			// src/projet.g:138:28: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==17) ) {
				alt36=1;
			}
			else if ( (LA36_0==10||LA36_0==14||LA36_0==18||LA36_0==26||LA36_0==37||(LA36_0 >= 39 && LA36_0 <= 40)||LA36_0==42||LA36_0==52) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// src/projet.g:138:33: ':=' expression
					{
					match(input,17,FOLLOW_17_in_affouappel981); 
					pushFollow(FOLLOW_expression_in_affouappel983);
					expression();
					state._fsp--;

					PtGen.pt(71);
					}
					break;
				case 2 :
					// src/projet.g:139:17: ( effixes ( effmods )? )?
					{
					// src/projet.g:139:17: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==10) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// src/projet.g:139:18: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel1004);
							effixes();
							state._fsp--;

							// src/projet.g:139:26: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==10) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// src/projet.g:139:27: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel1007);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					PtGen.pt(220);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// src/projet.g:143:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// src/projet.g:143:9: ( '(' ( expression ( ',' expression )* )? ')' )
			// src/projet.g:143:11: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effixes1039); 
			// src/projet.g:143:15: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==10||LA38_0==13||LA38_0==15||LA38_0==38||LA38_0==46||LA38_0==55) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// src/projet.g:143:16: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes1042);
					expression();
					state._fsp--;

					// src/projet.g:143:28: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==14) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// src/projet.g:143:29: ',' expression
							{
							match(input,14,FOLLOW_14_in_effixes1046); 
							pushFollow(FOLLOW_expression_in_effixes1048);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effixes1055); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// src/projet.g:146:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// src/projet.g:146:9: ( '(' ( ident ( ',' ident )* )? ')' )
			// src/projet.g:146:10: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effmods1067); 
			// src/projet.g:146:14: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// src/projet.g:146:15: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods1070);
					ident();
					state._fsp--;

					PtGen.pt(215);
					// src/projet.g:146:38: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==14) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// src/projet.g:146:39: ',' ident
							{
							match(input,14,FOLLOW_14_in_effmods1075); 
							pushFollow(FOLLOW_ident_in_effmods1077);
							ident();
							state._fsp--;

							PtGen.pt(215);
							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effmods1086); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// src/projet.g:149:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// src/projet.g:149:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// src/projet.g:149:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// src/projet.g:149:13: ( exp1 )
			// src/projet.g:149:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1100);
			exp1();
			state._fsp--;

			}

			// src/projet.g:149:20: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==47) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// src/projet.g:149:21: 'ou' exp1
					{
					match(input,47,FOLLOW_47_in_expression1104); 
					PtGen.pt(10);
					pushFollow(FOLLOW_exp1_in_expression1108);
					exp1();
					state._fsp--;

					PtGen.pt(10);
					PtGen.pt(11);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// src/projet.g:152:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// src/projet.g:152:7: ( exp2 ( 'et' exp2 )* )
			// src/projet.g:152:9: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11128);
			exp2();
			state._fsp--;

			// src/projet.g:152:14: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==35) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// src/projet.g:152:15: 'et' exp2
					{
					match(input,35,FOLLOW_35_in_exp11131); 
					PtGen.pt(10);
					pushFollow(FOLLOW_exp2_in_exp11135);
					exp2();
					state._fsp--;

					PtGen.pt(10);
					PtGen.pt(12);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// src/projet.g:155:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// src/projet.g:155:7: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==46) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==10||LA43_0==13||LA43_0==15||LA43_0==38||LA43_0==55) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// src/projet.g:155:9: 'non' exp2
					{
					match(input,46,FOLLOW_46_in_exp21155); 
					pushFollow(FOLLOW_exp2_in_exp21157);
					exp2();
					state._fsp--;

					PtGen.pt(10);
					PtGen.pt(13);
					}
					break;
				case 2 :
					// src/projet.g:156:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21168);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// src/projet.g:159:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// src/projet.g:159:7: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// src/projet.g:159:9: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31182);
			exp4();
			state._fsp--;

			// src/projet.g:160:3: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt44=1;
					}
					break;
				case 21:
					{
					alt44=2;
					}
					break;
				case 23:
					{
					alt44=3;
					}
					break;
				case 24:
					{
					alt44=4;
					}
					break;
				case 19:
					{
					alt44=5;
					}
					break;
				case 20:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// src/projet.g:160:5: '=' exp4
					{
					match(input,22,FOLLOW_22_in_exp31189); 
					pushFollow(FOLLOW_exp4_in_exp31193);
					exp4();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(15);
					PtGen.pt(25);
					}
					break;
				case 2 :
					// src/projet.g:161:5: '<>' exp4
					{
					match(input,21,FOLLOW_21_in_exp31205); 
					pushFollow(FOLLOW_exp4_in_exp31208);
					exp4();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(16);
					PtGen.pt(25);
					}
					break;
				case 3 :
					// src/projet.g:162:5: '>' exp4
					{
					match(input,23,FOLLOW_23_in_exp31220); 
					pushFollow(FOLLOW_exp4_in_exp31224);
					exp4();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(17);
					PtGen.pt(25);
					}
					break;
				case 4 :
					// src/projet.g:163:5: '>=' exp4
					{
					match(input,24,FOLLOW_24_in_exp31236); 
					pushFollow(FOLLOW_exp4_in_exp31239);
					exp4();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(18);
					PtGen.pt(25);
					}
					break;
				case 5 :
					// src/projet.g:164:5: '<' exp4
					{
					match(input,19,FOLLOW_19_in_exp31251); 
					pushFollow(FOLLOW_exp4_in_exp31255);
					exp4();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(19);
					PtGen.pt(25);
					}
					break;
				case 6 :
					// src/projet.g:165:5: '<=' exp4
					{
					match(input,20,FOLLOW_20_in_exp31267); 
					pushFollow(FOLLOW_exp4_in_exp31270);
					exp4();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(20);
					PtGen.pt(25);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// src/projet.g:169:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// src/projet.g:169:7: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// src/projet.g:169:9: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41296);
			exp5();
			state._fsp--;

			// src/projet.g:170:9: ( '+' exp5 | '-' exp5 )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==13) ) {
					alt45=1;
				}
				else if ( (LA45_0==15) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// src/projet.g:170:10: '+' exp5
					{
					match(input,13,FOLLOW_13_in_exp41308); 
					pushFollow(FOLLOW_exp5_in_exp41311);
					exp5();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(21);
					}
					break;
				case 2 :
					// src/projet.g:171:10: '-' exp5
					{
					match(input,15,FOLLOW_15_in_exp41326); 
					pushFollow(FOLLOW_exp5_in_exp41329);
					exp5();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(22);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// src/projet.g:175:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// src/projet.g:175:7: ( primaire ( '*' primaire | 'div' primaire )* )
			// src/projet.g:175:9: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51358);
			primaire();
			state._fsp--;

			// src/projet.g:176:9: ( '*' primaire | 'div' primaire )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==12) ) {
					alt46=1;
				}
				else if ( (LA46_0==32) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// src/projet.g:176:14: '*' primaire
					{
					match(input,12,FOLLOW_12_in_exp51374); 
					pushFollow(FOLLOW_primaire_in_exp51378);
					primaire();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(23);
					}
					break;
				case 2 :
					// src/projet.g:177:13: 'div' primaire
					{
					match(input,32,FOLLOW_32_in_exp51396); 
					pushFollow(FOLLOW_primaire_in_exp51399);
					primaire();
					state._fsp--;

					PtGen.pt(14);
					PtGen.pt(24);
					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// src/projet.g:181:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// src/projet.g:181:9: ( valeur | ident | '(' expression ')' )
			int alt47=3;
			switch ( input.LA(1) ) {
			case INT:
			case 13:
			case 15:
			case 38:
			case 55:
				{
				alt47=1;
				}
				break;
			case ID:
				{
				alt47=2;
				}
				break;
			case 10:
				{
				alt47=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// src/projet.g:181:11: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1426);
					valeur();
					state._fsp--;

					PtGen.pt(5);
					}
					break;
				case 2 :
					// src/projet.g:182:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1434);
					ident();
					state._fsp--;

					PtGen.pt(6);
					}
					break;
				case 3 :
					// src/projet.g:183:5: '(' expression ')'
					{
					match(input,10,FOLLOW_10_in_primaire1443); 
					pushFollow(FOLLOW_expression_in_primaire1445);
					expression();
					state._fsp--;

					match(input,11,FOLLOW_11_in_primaire1447); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// src/projet.g:186:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// src/projet.g:186:9: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 13:
				{
				alt48=2;
				}
				break;
			case 15:
				{
				alt48=3;
				}
				break;
			case 55:
				{
				alt48=4;
				}
				break;
			case 38:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// src/projet.g:186:11: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1461);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 2 :
					// src/projet.g:187:5: '+' nbentier
					{
					match(input,13,FOLLOW_13_in_valeur1469); 
					pushFollow(FOLLOW_nbentier_in_valeur1471);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 3 :
					// src/projet.g:188:5: '-' nbentier
					{
					match(input,15,FOLLOW_15_in_valeur1479); 
					pushFollow(FOLLOW_nbentier_in_valeur1481);
					nbentier();
					state._fsp--;

					PtGen.pt(2);
					}
					break;
				case 4 :
					// src/projet.g:189:5: 'vrai'
					{
					match(input,55,FOLLOW_55_in_valeur1489); 
					PtGen.pt(3);
					}
					break;
				case 5 :
					// src/projet.g:190:5: 'faux'
					{
					match(input,38,FOLLOW_38_in_valeur1497); 
					PtGen.pt(4);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// src/projet.g:201:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// src/projet.g:201:11: ( INT )
			// src/projet.g:201:15: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1528); 
			 UtilLex.valNb = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// src/projet.g:203:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// src/projet.g:203:7: ( ID )
			// src/projet.g:203:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1539); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite66 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite84 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unitprog104 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog108 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitprog111 = new BitSet(new long[]{0x00450000E0000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog120 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_unitprog129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unitmodule150 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule154 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitmodule158 = new BitSet(new long[]{0x00450000A0000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations183 = new BitSet(new long[]{0x0045000020000002L});
	public static final BitSet FOLLOW_partieref_in_declarations186 = new BitSet(new long[]{0x0041000020000002L});
	public static final BitSet FOLLOW_consts_in_declarations189 = new BitSet(new long[]{0x0041000000000002L});
	public static final BitSet FOLLOW_vars_in_declarations192 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_partiedef212 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef214 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partiedef219 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef221 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_partieref239 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref242 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partieref247 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref249 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partieref253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif267 = new BitSet(new long[]{0x0000120000000002L});
	public static final BitSet FOLLOW_41_in_specif279 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif281 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif283 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif290 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif292 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif300 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_specif325 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif328 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif330 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif337 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif339 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_consts364 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts369 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_consts372 = new BitSet(new long[]{0x008000400000A040L});
	public static final BitSet FOLLOW_valeur_in_consts374 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_ptvg_in_consts379 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_54_in_vars398 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_vars404 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars406 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_14_in_vars412 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars415 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_ptvg_in_vars423 = new BitSet(new long[]{0x0000000408000002L});
	public static final BitSet FOLLOW_34_in_type443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs472 = new BitSet(new long[]{0x0001000000040000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs474 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_48_in_decproc490 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc493 = new BitSet(new long[]{0x0040120060000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc497 = new BitSet(new long[]{0x0040100060000000L});
	public static final BitSet FOLLOW_parmod_in_decproc500 = new BitSet(new long[]{0x0040000060000000L});
	public static final BitSet FOLLOW_consts_in_decproc505 = new BitSet(new long[]{0x0040000040000000L});
	public static final BitSet FOLLOW_vars_in_decproc508 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_decproc511 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_ptvg527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_corps545 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_corps547 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_corps549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parfixe562 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parfixe564 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe566 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parfixe570 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe572 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parfixe576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf590 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf592 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pf598 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf600 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_44_in_parmod620 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parmod622 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod624 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parmod628 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod630 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parmod634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm648 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm650 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pm656 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm658 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_instruction_in_instructions678 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_instructions682 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instruction_in_instructions684 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_inssi_in_instruction701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_inssi748 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inssi750 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_inssi754 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi756 = new BitSet(new long[]{0x0010040000000000L});
	public static final BitSet FOLLOW_52_in_inssi759 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi764 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_inssi768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_inscond783 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond788 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond792 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond794 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_14_in_inscond809 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond814 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond818 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond820 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_26_in_inscond837 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond842 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_inscond861 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_boucle877 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_boucle881 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle885 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_boucle887 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_lecture903 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lecture905 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture907 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_lecture913 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture915 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_lecture922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ecriture935 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ecriture937 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture939 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_ecriture946 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture948 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_ecriture955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel971 = new BitSet(new long[]{0x0000000000020402L});
	public static final BitSet FOLLOW_17_in_affouappel981 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_affouappel983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel1004 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_effmods_in_affouappel1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effixes1039 = new BitSet(new long[]{0x008040400000AC60L});
	public static final BitSet FOLLOW_expression_in_effixes1042 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effixes1046 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_effixes1048 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effixes1055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effmods1067 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_ident_in_effmods1070 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effmods1075 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods1077 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effmods1086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1100 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_expression1104 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp1_in_expression1108 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11128 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exp11131 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp11135 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_46_in_exp21155 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp21157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31182 = new BitSet(new long[]{0x0000000001F80002L});
	public static final BitSet FOLLOW_22_in_exp31189 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_exp31205 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31220 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exp31236 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31251 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31267 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41296 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_exp41308 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41311 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_exp41326 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41329 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_primaire_in_exp51358 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_12_in_exp51374 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51378 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_32_in_exp51396 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51399 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_valeur_in_primaire1426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_primaire1443 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_primaire1445 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_primaire1447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_valeur1469 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_valeur1479 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_valeur1489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_valeur1497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1539 = new BitSet(new long[]{0x0000000000000002L});
}
