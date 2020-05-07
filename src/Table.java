
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
 /*-------énumératon de parties--------*/ 
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
/*----fontion d'égalité d'une piéce avec un domino téte-----*/
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
/*--fonction gérant l'ajout d'une piéce sur la table--*/   
 public boolean ajouterPiece(Domino dominoA,int partieA)
  {
     
     if (partieHaute.size()==0) //si les 2 vecteurs sont vide 
        { partieHaute.addElement(dominoA);
          partieBasse.addElement(dominoA);
          return true ;  
        }
     if(partieA==partie.haut)
     {    //si la piece est posée en haut
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
     //si la piece est posée en bas//
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
