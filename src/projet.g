// Grammaire du langage PROJET
// COMP L3  
// Anne Grazon, Veronique Masson
// il convient d'y inserer les appels a {PtGen.pt(k);}
// relancer Antlr apres chaque modification et raffraichir le projet Eclipse le cas echeant

// attention l'analyse est poursuivie apres erreur si l'on supprime la clause rulecatch

// ADILI ROBIN - LEBOULANGER HUGUES - TOMAS PABLO

grammar projet;

options {
  language=Java; k=1;
 }

@header {           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
} 


// partie syntaxique :  description de la grammaire //
// les non-terminaux doivent commencer par une minuscule


@members {

 
// variables globales et methodes utiles a placer ici
  
}
// la directive rulecatch permet d'interrompre l'analyse a la premiere erreur de syntaxe
@rulecatch {
catch (RecognitionException e) {reportError (e) ; throw e ; }}


unite  :   unitprog  {PtGen.pt(304);} EOF
      |    unitmodule {PtGen.pt(304);}  EOF
  ;
  
unitprog
  : 'programme' {PtGen.pt(301);} ident {PtGen.pt(303);}':'  
     declarations  
     corps {PtGen.pt(1000);} { System.out.println("succes, arret de la compilation "); }
  ;  
  
unitmodule
  : 'module' {PtGen.pt(302);} ident {PtGen.pt(303);} ':' 
     declarations { System.out.println("succes, arret de la compilation "); }
  ;
  
declarations
  : partiedef? partieref? consts? vars? decprocs? 
  ;
  
partiedef
  : 'def' ident {PtGen.pt(300);} (',' ident {PtGen.pt(300);})* ptvg
  ;
  
partieref: 'ref'  specif {PtGen.pt(314);} (',' specif)* ptvg
  ;
  
specif  : ident {PtGen.pt(310);} 
				 ( 'fixe' '(' type  {PtGen.pt(311);}{PtGen.pt(312);}( ',' type {PtGen.pt(311);}{PtGen.pt(312);} )* ')' )? 
                 ( 'mod'  '(' type  {PtGen.pt(311);}{PtGen.pt(313);}( ',' type {PtGen.pt(311);}{PtGen.pt(313);} )* ')' )?
  ;
  
consts  : 'const'  ( ident  '=' valeur  {PtGen.pt(60);} ptvg  )+ 
  ;
  
vars  : 'var' {PtGen.pt(52);} ( type ident {PtGen.pt(53);} ( ','  ident {PtGen.pt(53);}  )* ptvg  )+ {PtGen.pt(54);}
  ;
  
type  : 'ent' {PtGen.pt(50);} 
  |     'bool' {PtGen.pt(51);}
  ;
  
decprocs: {PtGen.pt(198);}(decproc ptvg)+{PtGen.pt(199);}
  ;
  
decproc : 'proc'  ident {PtGen.pt(200);} parfixe? parmod? {PtGen.pt(203);} consts? vars? corps {PtGen.pt(210);}
  ;
  
ptvg  : ';'
  | 
  ;
  
corps : 'debut' instructions 'fin' 
  ;
  
parfixe: 'fixe' '(' pf ( ';' pf)* ')'
  ;
  
pf  : type ident {PtGen.pt(201);} ( ',' ident  {PtGen.pt(201);} )*  
  ;

parmod  : 'mod' '(' pm ( ';' pm)* ')'
  ;
  
pm  : type ident {PtGen.pt(202);} ( ',' ident {PtGen.pt(202);} )*
  ;
  
instructions
  : instruction ( ';' instruction)*
  ;
  
instruction
  : inssi
  | inscond
  | boucle
  | lecture
  | ecriture
  | affouappel
  |
  ;
  
inssi : 'si' expression {PtGen.pt(100);} 'alors' instructions ('sinon' {PtGen.pt(101);}  instructions)? 'fsi' {PtGen.pt(102);}
  ;
  
inscond : 'cond' {PtGen.pt(120);}  expression {PtGen.pt(121);} ':' instructions  
          (','  {PtGen.pt(122);} expression {PtGen.pt(121);} ':' instructions )* 
          ('aut'  {PtGen.pt(122);} instructions | {PtGen.pt(124);} ) 
          'fcond' {PtGen.pt(123);}
  ;
  
boucle  : 'ttq' {PtGen.pt(140);} expression {PtGen.pt(141);} 'faire' instructions 'fait' {PtGen.pt(142);}
  ;
  
lecture: 'lire' '(' ident  {PtGen.pt(80);}( ',' ident  {PtGen.pt(80);})* ')' 
  ;
  
ecriture: 'ecrire' '(' expression  {PtGen.pt(81);} ( ',' expression  {PtGen.pt(81);})* ')'
   ;
  
affouappel
  : ident  {PtGen.pt(70);} (    ':=' expression {PtGen.pt(71);}
            |   (effixes (effmods)?)?{PtGen.pt(220);} 
           )
  ;
  
effixes : '(' (expression  (',' expression )*)? ')'
  ;
  
effmods :'(' (ident {PtGen.pt(215);} (',' ident {PtGen.pt(215);} )*)? ')'
  ; 
  
expression: (exp1) ('ou' {PtGen.pt(10);} exp1 {PtGen.pt(10);} {PtGen.pt(11);})*
  ;
  
exp1  : exp2 ('et' {PtGen.pt(10);} exp2 {PtGen.pt(10);} {PtGen.pt(12);})*
  ;
  
exp2  : 'non' exp2 {PtGen.pt(10);} {PtGen.pt(13);} 
  | exp3
  ;
  
exp3  : exp4 
  ( '='   exp4 {PtGen.pt(14);} {PtGen.pt(15);} {PtGen.pt(25);}
  | '<>'  exp4 {PtGen.pt(14);} {PtGen.pt(16);} {PtGen.pt(25);}
  | '>'   exp4 {PtGen.pt(14);} {PtGen.pt(17);} {PtGen.pt(25);}
  | '>='  exp4 {PtGen.pt(14);} {PtGen.pt(18);} {PtGen.pt(25);}
  | '<'   exp4 {PtGen.pt(14);} {PtGen.pt(19);} {PtGen.pt(25);}
  | '<='  exp4 {PtGen.pt(14);} {PtGen.pt(20);} {PtGen.pt(25);}
  ) ?
  ;
  
exp4  : exp5 
        ('+'  exp5 {PtGen.pt(14);} {PtGen.pt(21);}
        |'-'  exp5 {PtGen.pt(14);} {PtGen.pt(22);}
        )*
  ;
  
exp5  : primaire 
        (    '*'   primaire {PtGen.pt(14);} {PtGen.pt(23);}
          | 'div'  primaire {PtGen.pt(14);} {PtGen.pt(24);}
        )*
  ;
  
primaire: valeur {PtGen.pt(5);}
  | ident  {PtGen.pt(6);}
  | '(' expression ')'
  ;
  
valeur  : nbentier {PtGen.pt(1);}
  | '+' nbentier {PtGen.pt(1);}
  | '-' nbentier {PtGen.pt(2);}
  | 'vrai' {PtGen.pt(3);}
  | 'faux' {PtGen.pt(4);}
  ;


// partie lexicale  : cette partie ne doit pas etre modifie  //
// les unites lexicales de ANTLR doivent commencer par une majuscule
// attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
// il est alors ncessaire de passer par un non-terminal intermediaire 
// exemple : pour l'unit lexicale INT, le non-terminal nbentier a du etre introduit
 
      
nbentier  :   INT { UtilLex.valNb = Integer.parseInt($INT.text);}; // mise a jour de valNb

ident : ID  { UtilLex.traiterId($ID.text); } ; // mise a jour de numId
     // tous les identificateurs seront places dans la table des identificateurs, y compris le nom du programme ou module
     // la table des symboles n'est pas geree au niveau lexical
        
  
ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; 
     
// zone purement lexicale //

INT :   '0'..'9'+ ;
WS    :   (' '|'\t' |'\r')+ {skip();} ; // definition des "espaces"
LIGNE :   '\n' {UtilLex.incrementeLigne();skip();};


COMMENT
  :  '\{' (.)* '\}' {skip();}   // toute suite de caracteres entouree d'accolades est un commentaire
  |  '#' ~( '\r' | '\n' )* {skip();}  // tout ce qui suit un caractere diese sur une ligne est un commentaire
  ;

// commentaires sur plusieurs lignes
ML_COMMENT    :   '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
    ;	   



	   