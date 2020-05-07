
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sniper Ninja
 */
public class Joueur {
    private Vector Main ;
    private String nomJoueur ;

  /*--------constructeur--------*/
  public Joueur(String nom) 
  {   Main=new Vector(14);    
      nomJoueur=nom;
  }
  /*-----------------------------*/  
  /*------ énumération de décisions-----------*/
   public class decision { 
                          final static int passe=0;
                          final static int joue =1;
                          final static int joue_khabta=2;
                         }
 /*-------------------------------------------*/
 /*-----------------accesseurs----------------*/
 public String avoirNom(){return nomJoueur;}
 public Vector avoirMain(){return Main;}
 /*-------------------------------------------*/  
 /*---fonction qui enleve une piece d'une main--*/
 void enleverPiece(Domino D){Main.removeElement(D);}
 /*--------------------------------------------*/
 /*---fonction ajoutant une piece à une main---*/
 void ajouterPiece(Domino Piece)
   {Main.addElement(Piece);}
 /*--------------------------------------------*/
 /*----fonction changeant le nom du joueur-----*/
 void affecterNom(String nouveauNom)
 { nomJoueur=nouveauNom;}
 /*-------------------------------------------*/
 /*------------fonction de décompte------------*/
 int decompte()
 {  int s=0;
    Domino d;
    if (Main.size()==0) return 0;
    for(int i=0;i<Main.size();i++)
    {
      d=(Domino)(Main.elementAt(i)) ;
      s=s+d.avoirHaut()+d.avoirBas();
    } 
    return s;
  }
 /*--------------------------------------------*/  
 /*-vérifier si le joueur peut passer sa main-*/
  public boolean peutPasser(Table partieTable)
    { 
       if(partieTable.avoirpartieHaute().size()==0)
         return false ; 
       for(int i=0;i<Main.size();i++)
          if(partieTable.egale((Domino)(Main.elementAt(i))))
              return false;
      return true ; 
    }
 /*------------------------------------------*/

}
