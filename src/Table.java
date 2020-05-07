
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sniper Ninja
 */
public class Table {

    private Vector partieHaute ;
    private Vector partieBasse ; 
 /*-------�num�raton de parties--------*/ 
   public class partie {
      final static int haut=0;
      final static int bas=1;
  }   
 /*------------------------------------*/
 /*--fonction d'initialisation de la table--*/
     public Table()
      { partieHaute=new Vector(28);
        partieBasse=new Vector(28);
      }
 /*----------------------------------------*/

/*--------------------accesseurs---------------------*/
 public Vector avoirpartieHaute(){ return partieHaute;}
 public Vector avoirPartieBasse(){ return partieBasse;}    
/*----------------------------------------------------*/     
/*----fontion d'�galit� d'une pi�ce avec un domino t�te-----*/
public boolean egale(Domino dominoA)
{  Domino bas=(Domino)(partieBasse.lastElement());
   Domino haut=(Domino)(partieHaute.lastElement());
   if(dominoA.avoirHaut()==haut.avoirHaut() ||
      dominoA.avoirBas()==haut.avoirHaut() ||
      dominoA.avoirHaut()==bas.avoirBas() ||
      dominoA.avoirBas()==bas.avoirBas() ) 
       return true;    
     else return false; 
}  
/*----------------------------------------------------*/ 
/*----------------------------------------------------*/
/*--fonction g�rant l'ajout d'une pi�ce sur la table--*/   
 public boolean ajouterPiece(Domino dominoA,int partieA)
  {
     
     if (partieHaute.size()==0) //si les 2 vecteurs sont vide 
        { partieHaute.addElement(dominoA);
          partieBasse.addElement(dominoA);
          return true ;  
        }
     if(partieA==partie.haut)
     {    //si la piece est pos�e en haut
          Domino x=(Domino)(partieHaute.lastElement()); 
          if(dominoA.avoirHaut()==x.avoirHaut())
            { dominoA.flip();
              partieHaute.addElement(dominoA);  
              return true;
            }else
            {  if(dominoA.avoirBas()==x.avoirHaut())
               { partieHaute.addElement(dominoA); 
                 return true;
               }else return false;  
            
            }    
     //si la piece est pos�e en bas//
     }else 
     {
         Domino x=(Domino)(partieBasse.lastElement()); 
          if(dominoA.avoirHaut()==x.avoirBas())
            { partieBasse.addElement(dominoA);  
              return true;
            }else
            {  if(dominoA.avoirBas()==x.avoirBas())
               { dominoA.flip();
                 partieBasse.addElement(dominoA); 
                 return true;
               
               }else return false;  
            
            }    
         
     }  
    
     
    
    
  } 
  /*------------------------------------------------------*/  

}
