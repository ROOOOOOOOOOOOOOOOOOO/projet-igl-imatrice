/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author karim
 */
public class Decomposition {
    
    public Decomposition() {
        
    }
    
    
    public ArrayList<Matrice> decompserLU(Matrice a) {
        //Matrice identite
        Float[][] identite;
        identite = new Float[a.getNbLigne()][a.getNbColonne()];
        for(int i=0;i<a.getNbLigne();i++) {
            for (int j=0;j<a.getNbColonne();j++) {
                if (i==j) identite[i][j] = 1.f;
                else identite[i][j] = 0.f;
            }
        }
        Matrice l = new Matrice(a.getNbLigne(), a.getNbColonne());
        l.setElements(identite);
        //
        Matrice mat = a;
        for (int k=0;k<mat.getNbLigne();k++) {
            float diag = mat.getElements()[k][k];
            for (int i=k+1;i<mat.getNbLigne();i++) {
                float b = mat.getElements()[i][k];
                mat.getElements()[i][k] = 0.f;
                l.getElements()[i][k] = b/diag;
                for (int j=k+1;j<mat.getNbColonne();j++) {
                    mat.getElements()[i][j] = mat.getElements()[i][j] - mat.getElements()[k][j]*b/diag;
                }
            }
        }
        
        ArrayList<Matrice> list = new ArrayList<>();
        OpUnaire op = new OpUnaire();
        list.add(l);//Matrice L
        list.add(op.triangulariserSup(a)); //Matrice U
        
        return list;
    }
    
   public ArrayList<Matrice> decomposerLLt(Matrice a){
       Matrice u=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice racineU=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice l=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice lc=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice lt=new Matrice(a.getNbLigne(),a.getNbColonne());
       OpBinaire op=new OpBinaire();
       ArrayList<Matrice> LLt=new ArrayList();
        ArrayList<Matrice> lu=new ArrayList();
       lu=decompserLU(a);
       u=lu.get(1);
       l=lu.get(0);
          for (int i=0;i<a.getNbLigne();i++){
           for (int j=0;j<a.getNbColonne();j++){
               if (i==j){
                   racineU.remplir_case(racineU, i, j,(float) Math.sqrt(u.soustraire_val(u, i, j)));
                }
               else{
                   racineU.remplir_case(racineU,i,j,0);
               }
           }
       } 
       
           for (int i=0;i<a.getNbLigne();i++){
           for (int j=0;j<a.getNbColonne();j++){
               if (i<j){
               lt.remplir_case(lt, i, j, u.soustraire_val(u, i, j)/racineU.soustraire_val(racineU, i, i));
               {
               if (i==j){
                   lt.remplir_case(lt, i, i,(float)(Math.sqrt(racineU.soustraire_val(racineU, i, j))));
               }    
               else{
                   lt.remplir_case(lt, i, j, 0);
               }
               
           }
   
   
             } 
           }
           }
           lc=op.multiplication(l, racineU);
           LLt.add(lc);
           LLt.add(lt);
           return LLt;       
   }
   
   public ArrayList<Matrice> decomposerQR(Matrice a){
       Matrice ta=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice newa=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice l=new Matrice (a.getNbLigne(),a.getNbColonne());
       Matrice u=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice d=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice rt=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice r=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice q=new Matrice(a.getNbLigne(),a.getNbColonne());
       Matrice dinverse=new Matrice(a.getNbLigne(),a.getNbColonne());
       ArrayList<Matrice> lu=new ArrayList();
       ArrayList<Matrice> qr=new ArrayList();
       OpUnaire opu=new OpUnaire();
       OpBinaire opb=new OpBinaire();
       ta=opu.transposeeMatrice(a);
       newa=opb.multiplication(ta, a);
       lu=decompserLU(newa);
       l=lu.get(0);
       u=lu.get(1);
       for (int i=0;i<a.getNbLigne();i++){
           for (int j=0;j<a.getNbColonne();j++){
               if (i==j){
                   d.remplir_case(d, i, j,(float) Math.sqrt(u.soustraire_val(u, i, j)));
                }
               else{
                   d.remplir_case(d,i,j,0);
               }
           }
       } 
       dinverse=opu.inverse(d);
       rt=opb.multiplication(l, d);
       r=opb.multiplication(dinverse, u);
       q=opb.multiplication(a, opu.inverse(r));
       qr.add(q);
       qr.add(r);
       return qr;
       
}
}
