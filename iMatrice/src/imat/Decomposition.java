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
    
    
    public ArrayList<Matrice> decomposerCholeskyBBt(Matrice a) {
        
        Decomposition dec = new Decomposition();
        Iterator<Matrice> it = dec.decompserLU(a).iterator();
        Matrice l = it.next();
        Matrice u = it.next();
        Matrice d = new Matrice(u.getNbLigne(),u.getNbColonne());
        Matrice dInverse = new Matrice(u.getNbLigne(),u.getNbColonne());
        Float[][] tabD = new Float[u.getNbLigne()][u.getNbColonne()];
        Float[][] tabDinverse = new Float[u.getNbLigne()][u.getNbColonne()];
        for (int i=0;i<u.getNbLigne();i++) {
            for (int j=0;j<u.getNbColonne();j++) {
                if (i==j) {
                    tabD[i][j] = (float)Math.sqrt(u.getElements()[i][j]);
                    tabDinverse[i][j] = (float)(1/Math.sqrt(u.getElements()[i][j]));
                }
                else {
                    tabD[i][j] =  0.f;
                    tabDinverse[i][j] = 0.f;
                } 
            }
        }
        d.setElements(tabD);
        dInverse.setElements(tabDinverse);
        
        Matrice b = null,bt = null;
        OpBinaire op = new OpBinaire();
        b = op.mulMatrice(l, d);
        bt = op.mulMatrice(dInverse, u);
        
        ArrayList<Matrice> list = new ArrayList<>();
        list.add(b);
        list.add(bt);
        return list;
    }
    
}
