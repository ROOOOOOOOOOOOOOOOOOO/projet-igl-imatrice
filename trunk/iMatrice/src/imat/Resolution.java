/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.Iterator;

/**
 *
 * @author karim
 */
public class Resolution {
    
    private Matrice mat;
    private float[] vect;
    
    public Resolution(Matrice a, float[] tab) {
        this.mat = a;
        this.vect = tab;
    }
    
    
    public Float[] resoudreLU() {
        //L.z=b
        Float[] resZ = new Float[vect.length];
        Decomposition dec = new Decomposition();
        Iterator<Matrice> it = dec.decompserLU(mat).iterator();
        Matrice l = it.next();
        Matrice u = it.next();
        int k=0;
        float a = 0;
        resZ[0] = vect[k]/l.getElements()[k][k];
        for (int i=1;i<l.getNbLigne();i++) {
            for(int j=0;j<i;j++) {
                a = a + l.getElements()[i][j]*resZ[k];
                k++;
            }
            resZ[i] = (vect[i] - a) / l.getElements()[i][i];
            a = 0;
            k = 0;
        }
        //U.x=z
        Float[] res = new Float[vect.length];
        k = resZ.length - 1;
        res[k] = resZ[k]/u.getElements()[k][k];
        for (int i=resZ.length-2;i>=0;i--) {
            for(int j=resZ.length-1;j>i;j--) {
                a = a + u.getElements()[i][j]*res[k];
                k--;
            }
            res[i] = (resZ[k] - a) / u.getElements()[i][i];
            a = 0;
            k = resZ.length - 1;
        }
        return res;
    }
    
    
    public Float[] resoudreBBt() {
        //B.z=b
        Float[] resZ = new Float[vect.length];
        Decomposition dec = new Decomposition();
        Iterator<Matrice> it = dec.decompserLU(mat).iterator();
        Matrice b = it.next();
        Matrice bt = it.next();
        int k=0;
        float a = 0;
        resZ[0] = vect[k]/b.getElements()[k][k];
        for (int i=1;i<b.getNbLigne();i++) {
            for(int j=0;j<i;j++) {
                a = a + b.getElements()[i][j]*resZ[k];
                k++;
            }
            resZ[i] = (vect[i] - a) / b.getElements()[i][i];
            a = 0;
            k = 0;
        }
        //Bt.x=z
        Float[] res = new Float[vect.length];
        k = resZ.length - 1;
        res[k] = resZ[k]/bt.getElements()[k][k];
        for (int i=resZ.length-2;i>=0;i--) {
            for(int j=resZ.length-1;j>i;j--) {
                a = a + bt.getElements()[i][j]*res[k];
                k--;
            }
            res[i] = (resZ[k] - a) / bt.getElements()[i][i];
            a = 0;
            k = resZ.length - 1;
        }
        return res;
    }
    
    
    public void afficherSolution(Float[] tab) {
        for (int i=0;i<tab.length;i++) {
            System.out.println(tab[i]);
        }
    }

    
}
