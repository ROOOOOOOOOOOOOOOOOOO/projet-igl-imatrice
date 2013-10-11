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
        return Math.round(det);
    }
    
    public float cofacteur(Matrice l,int i,int j){
        // boolean continu=true;
         int  x=0,w=0;
         int signe;
         Matrice c=new Matrice(l.getNbLigne()-1,l.getNbColonne()-1);
         OpUnaire op=new OpUnaire();
         for (int k=0;k<l.getNbLigne();k++){
            for (int m=0;m<l.getNbColonne();m++){
                if (k!=i & m!=j){
                    c.remplir_case(c, x,w,l.soustraire_val(l, k, m)) ;
                    w++;
                }                            
            }
            w=0;
            if (k==i){
                x--;
            }
            x++;       
         }
         System.out.println("voici la comatrice de "+i+","+j);
         c.afficherMatrice();
         System.out.println(" Voici son determinant "+op.determinant(c));
         System.out.println("c quoi ce ((-1)puissanc(i+j+2))="+((-1)^(i+j+2)));
         signe=(int)(Math.pow((-1),i+j+2));

         return ((float)(signe*op.determinant(c)));
    }
    
    
    public Matrice comatrice(Matrice a){
        
        //Matrice b=new Matrice(a.getNbLigne()-1,a.getNbColonne()-1);
        Matrice com=new Matrice (a.getNbLigne(),a.getNbColonne());
        OpUnaire co=new OpUnaire();
        for (int i=0;i<a.getNbLigne();i++){
            for (int j=0;j<a.getNbColonne();j++){
                com.remplir_case(com, i, j, co.cofacteur(a, i, j));
            }
        }
        return com;
    }
          
    
    public Matrice inverse (Matrice a){
        Matrice b=new Matrice(a.getNbLigne(),a.getNbColonne());
        OpUnaire op=new OpUnaire();
        b=op.comatrice(a);
        b=op.transposeeMatrice(b);
        for (int i=0;i<b.getNbLigne();i++){
             for (int j=0;j<b.getNbColonne();j++){
                 b.remplir_case(b, i, j, b.soustraire_val(b, i, j)/op.determinant(a));
             }
          }
        return b ;
    }
    
    
    public float conditionnement(Matrice a) {
        OpUnaire op = new OpUnaire();
        return op.norme(a)*op.norme(op.inverse(a));
    }
    
}
