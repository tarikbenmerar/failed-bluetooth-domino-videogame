
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sniper Ninja
 */
public class Partie {
 /*-------Les variables--------*/  
 private Table tablePartie ;
 private Joueur joueur1;
 private Joueur joueur2;
 private Joueur joueur3;
 private Joueur joueur4;
 private Vector resteDomino ;
 private Vector prioriteDomino ;
 private int    modePartie ;
 private int    nbrPasse;
 private int    nbrPartie ;
 private int    jetonActuel ;
 private int    jeton ;
 private int    cote ;
 private int    decompteEquipe1;
 private int    decompteEquipe2;
 //enumerations
 public class Mode {
     final static int _4joueurs=0;
     final static int _2joueurs=1;
 }
 public class Cote {
   final static int esclave=0;
   final static int maitre=1;
 }
 public class SuiteDecision
 {
    final static int pasDeNouveau=0;
    final static int finDePartie=1 ;
    final static int finDeJeu=2    ;
  }
 /*-------------------------------*/   
 /*----------constructeur---------*/
 public Partie(int ModePartieI,int CoteI)
 { tablePartie=new Table();
   //remplir resteDomino
   modePartie=ModePartieI;
   cote=CoteI;
   nbrPartie=0;
   nbrPasse=0;
   decompteEquipe1=0;
   decompteEquipe2=0;
 }        
 /*-------------------------------*/
 /*----------Accesseurs-----------*/
 public Vector partieHauteTable()
 {return tablePartie.avoirpartieHaute();}
 /*---------*/
 public Vector partieBassePartie()
 {return tablePartie.avoirPartieBasse();}
 /*--------*/
 Joueur avoirJoueur(int numeroJoueur)
 { 
  switch(numeroJoueur)
   { case 1: return joueur1;
     case 2: return joueur2;
     case 3: return joueur3;
     case 4: return joueur4; 
   }        
  return null;   
 }        
 /*---------*/
 public Vector avoirReste() {return resteDomino ;}
 /*---------*/
 public int avoirMode()  {return modePartie;}
 /*--------*/
 public int avoirmonJeton(){return jeton;}
 /*-------*/
 public int avoirCote(){return cote;}
 /*-------*/
 public int equipe(int numeroJoueur)
 { 
   if(numeroJoueur==1 || numeroJoueur==3)
       return 1;
    return 2 ; 
 }
 /*-------*/
 public int decompte(int numeroEquipe)
 {  switch(numeroEquipe)
    { case 1: return decompteEquipe1;
      case 2: return decompteEquipe2;
    }        
    return -1;
 }        
 /*------*/
 public int avoirNbrPartie(){return nbrPartie;}
 /*------*/
 public int avoirJetonActuel(){return jetonActuel;}
 /*------*/
 public boolean etatBlockage(){return(nbrPasse==4);}
 /*------------------------------*/
 /*--fonction gérant les décisions des joueurs--*/
 /***--il faut ajouter la partie gérant 2joueurs--------*/
 public boolean gererDecision(int numeroJoueur,int Decision,Domino D,int partie)
 { if(Decision==Joueur.decision.passe)
   { if(avoirJoueur(numeroJoueur).peutPasser(tablePartie))
     {  nbrPasse++;
        jetonActuel=(jetonActuel)%4+1;
         return true;
     }else return false;    
   }
   else
   { if(Decision==Joueur.decision.joue || Decision==Joueur.decision.joue_khabta)
       if(tablePartie.ajouterPiece(D, partie))
       { avoirJoueur(numeroJoueur).enleverPiece(D);
         jetonActuel=(jetonActuel)%4+1;
         return true;
       }else return false ;  
       
   }  
   return false ;
 }        
 /*--------------------------------------------*/
 /*----Fonction d'initialisation d'une partie----*/
 public void initialiser(boolean nouveauJeton)
 { tablePartie=new Table(); 
   if(cote==Cote.maitre)
    {//si il est maitre  
    //remplir ResteDomino
    //Destribuer les dominos sur les joueurs
    nbrPasse=0;
    if(nouveauJeton)
      {
        //verifier un à un le joueur qui a double six
        //*ca ne gere pas le cas de 2 joueurs
      }    
  
   }
 }        
 /*--------------------------------------------*/
 /*--fonction retournant le joueur avec la main minimum---*/
 public int joueurMainMinimum()
 { int x1,x2;
   //choisir le meillieur joueur de l'équipe 1
   if(joueur1.decompte()<=joueur3.decompte())
    x1=1;
   else    
    x1=3;   
   //choisir le meillieur joueur de l'equipe 2
   if(joueur2.decompte()<=joueur4.decompte())
     x2=2;
   else 
     x2=4;   
   //trancher sur le joueur avec le decompte minimum
   if(avoirJoueur(x1).decompte()<avoirJoueur(x2).decompte())
    return x1;
   else
     if(avoirJoueur(x2).decompte()<avoirJoueur(x1).decompte())
      return x2;
     else
      return 0;
   
   
 }        
 /*-------------------------------------------------------*/
 /*------Fonction affectant un decompte à une equipe------*/
 private void affecterDecompte (int equipe,int nouveauDecompte)
 { switch(equipe)
   { case 1:
            decompteEquipe1=nouveauDecompte;
            break;
     case 2:  
            decompteEquipe2=nouveauDecompte;   
   }        
     
 }        
 /*-------------------------------------------------------*/
 /*---fonction gérant la suite du jeu aprés une prise d'une décision*/
 public int gererSuite(int decision,int numeroJoueur,Domino D,int Partie)
 { 
  if(gererDecision(decision,numeroJoueur,D,Partie))
   {                      
      
   }
      return 0;
 }
 /*-----------------------------------------------------------------*/
}
