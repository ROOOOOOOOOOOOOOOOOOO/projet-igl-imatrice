/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

/**
 *
 * @author karim
 */
public class OpBinaire {
    
    
    public OpBinaire() {
        
    }
    
    
    public Matrice addMatrice(Matrice a, Matrice b) {
        Matrice res = null;
        if(a.getNbLigne()==b.getNbLigne() && a.getNbColonne()==b.getNbColonne()) {
            res = new Matrice(a.getNbLigne(), a.getNbColonne());
            for(int i=0;i<res.getNbLigne();i++) {
                for (int j=0;j<res.getNbColonne();j++) {
                    res.getElements()[i][j] = a.getElements()[i][j] + b.getElements()[i][j];
                }
            }
        }
        return res;
    }
    
    
    public Matrice mulMatrice(Matrice a, Matrice b) {
        Matrice res = null;
        if(a.getNbColonne()==b.getNbLigne()) {
            res = new Matrice(a.getNbLigne(),b.getNbColonne());
            float val=0,s=0;
            int k=0;
            for (int i=0;i<res.getNbLigne();i++){
                for(int j=0;j<res.getNbColonne();j++){
                    while(k<a.getNbColonne()){
                        val = val + (a.getElements()[i][k]*b.getElements()[k][j]);
                        res.getElements()[i][j] = val;
                        k++;
                    }
                    val = 0;
                    k = 0;
                }
            }
        }
        return res;
    }

    
}
