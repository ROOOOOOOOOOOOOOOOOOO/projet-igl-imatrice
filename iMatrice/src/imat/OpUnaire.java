package imat;

import imat.Matrice;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karim
 */
public class OpUnaire {
    
    
    public OpUnaire() {
    } 
    
    
    public Matrice transposeeMatrice(Matrice a) {
        Matrice trans = new Matrice(a.getNbColonne(), a.getNbLigne());
        for(int j=0;j<a.getNbColonne();j++) {
            for(int i=0;i<a.getNbLigne();i++) {
               trans.getElements()[i][j] = a.getElements()[j][i];
            }
        }
        return trans;
    }
    
    
    public float norme(Matrice a) {
        float c = 0.f, norme = 0.f;
        for(int i=0;i<a.getNbLigne();i++){
            c = 0.f;
            for(int j=0;j<a.getNbColonne();j++) {
                c = c + Math.abs(a.getElements()[i][j]);
            }
            if(c > norme) norme = c;
        }
        return norme;
    }
    
    
    public Matrice triangulariserInf(Matrice a) {
        Matrice mat = a;
        for (int k=0;k<mat.getNbColonne();k++) {
            float diag = mat.getElements()[k][k];
            for (int j=k+1;j<mat.getNbColonne();j++) {
                float b = mat.getElements()[k][j];
                mat.getElements()[k][j] = 0.f;
                for (int i=k+1;i<mat.getNbLigne();i++) {
                    mat.getElements()[i][j] = mat.getElements()[i][j] - mat.getElements()[i][k]*b/diag;
                }
            }
        }
        return mat;
    }
    
    
    public Matrice triangulariserSup(Matrice a) {
        Matrice mat = a;
        for (int k=0;k<mat.getNbLigne();k++) {
            float diag = mat.getElements()[k][k];
            for (int i=k+1;i<mat.getNbLigne();i++) {
                float b = mat.getElements()[i][k];
                mat.getElements()[i][k] = 0.f;
                for (int j=k+1;j<mat.getNbColonne();j++) {
                    mat.getElements()[i][j] = mat.getElements()[i][j] - mat.getElements()[k][j]*b/diag;
                }
            }
        }
        return mat;
    }
    
    
    public float determinant(Matrice a) {
        float det = 1.f;
        OpUnaire op = new OpUnaire();
        //op.triangulariserInf(a);
        op.triangulariserInf(a);
        for (int i=0;i<a.getNbLigne();i++) {
            det = det * a.getElements()[i][i];
        }
        return det;
    }
    
}
