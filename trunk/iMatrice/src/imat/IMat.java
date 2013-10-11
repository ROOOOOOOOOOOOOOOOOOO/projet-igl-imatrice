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
public class IMat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matrice m = new Matrice(3,3);
//        Matrice m2 = new Matrice(3,1);
        m.remplirMatrice();
//        m2.remplirMatrice();
//        OpBinaire op = new OpBinaire();
//        op.mulMatrice(m, m2).afficherMatrice();
        float[] b = {10,3,-7};
        Resolution res = new Resolution(m, b);
        res.afficherSolution(res.resoudreBBt());
    }
}
