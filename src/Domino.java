/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sniper Ninja
 */
public class Domino {
    private int haut ;
    private int bas  ;
 /*---------constructeur---------*/
 public Domino(int dHaut,int dBas)
 { haut=dHaut;bas=dBas;}        
 /*------------------------------*/
 /*----------accesseurs----------*/
  public int avoirHaut(){return haut;}
  public int avoirBas(){return  bas;}
 /*------------------------------*/
 /*---fonction de permutation----*/
   public void flip()
    {
       int x;
       x=haut;
       haut=bas;
       bas=x;
    }
/*-----fin de la fonxtion-----*/
}
