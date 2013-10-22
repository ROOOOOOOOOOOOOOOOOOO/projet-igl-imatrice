/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;

/**
 * Classe Matrice :
 * Contient les elements caracterisant une matrice et quelques operations elementaires sur les matrices :
 * <ul>
 * <li>Remplir une matrice.</li>
 * <li>Generer une matrice.</li>
 * <li>Afficher une matrice.</li>
 * </ul>
 * @author karim
 * <ul>
 * <li>Issad Salim</li>
 * <li>Drid Akram</li>
 * </ul>
 * @version 1.0
 * @see OpUnaire
 * @see OpBinaire
 * @see Decomposition
 */
public class Matrice {
    
    /**
     * Nombre de lignes de la matrice.
     * @see Matrice#getNbLigne() 
     * @see Matrice#setNbLigne(int) 
     */
    private int nbLigne;
    
    /**
     * Nombre de colonnes de la matrice.
     * @see Matrice#getNbColonne()
     * @see Matrice#setNbColonne(int)
     */
    private int nbColonne;
    
    /**
     * Tableau deux dimensions contenant les elements de la matrice.
     * @see Matrice#getElements() () 
     * @see Matrice#setElements(java.lang.Float[][]) 
     */
    private Float[][] elements;

    /**
     * Constructeur avec parametres.
     * @param nbLigne le nombre de lignes
     * @param nbColonne le nombre de colonnes
     * @return une matrice de reels
     */
    public Matrice(int nbLigne, int nbColonne) {
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        this.elements = new Float[nbLigne][nbColonne];
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                this.elements[i][j] = 0.f;
            }
        }
    }

    /**
     * Le nombre de lignes d'une matrice.
     * @return Retourne le nombre de lignes.
     */
    public int getNbLigne() {
            return nbLigne;
    }

    /**
     * Affecte le nombre de lignes d'une matrice.
     * @param nbLigne nombre de lignes 
     */
    public void setNbLigne(int nbLigne) {
            this.nbLigne = nbLigne;
    }

    /**
     * Le nombre de colonnes d'une matrice.
     * @return le nombre de colonnes.
     */
    public int getNbColonne() {
            return nbColonne;
    }

    /**
     * Affecte le nombre de colonnes d'une matrice.
     * @param nbColonne le nombre de colonnes. 
     */
    public void setNbColonne(int nbColonne) {
            this.nbColonne = nbColonne;
    }

    /**
     * Retourne un tableau contenant les elements de la matrice.
     * @return une matrice de reels.
     */
    public Float[][] getElements() {
            return elements;
    }

    /**
     * Affecte un tableau contenant les elements de la matrice.
     * @param elements la matrice de reels.
     */
    public void setElements(Float[][] elements) {
            this.elements = new Float[nbLigne][nbLigne];
            for(int i=0;i<nbLigne;i++) {
            for (int j=0;j<nbColonne;j++) {
                this.elements[i][j] = elements[i][j]; 
            }
        }
    }
    
    /**
     * Remplir le tableau contenu dans la matrice.
     */
    public void remplirMatrice() {
        Scanner scanf = new Scanner(System.in);
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                System.out.print("a"+(i+1)+(j+1)+" = ");
                this.elements[i][j] = scanf.nextFloat();
            }
        }
    }
    /**
     * Generer aleatoirement des reels entre -a et a contenus dans le tableau de la matrice.
     * @param a un entier.
     */
    public void genererMatrice(int a) {
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                this.elements[i][j] = (float)Math.round(Math.random()*100-a);
            }
        }
    }
    
    /**
     * Remplacer une valeur de la matrice a la ieme ligne et la jeme colonne par val.
     * @param i la ieme ligne.
     * @param j la jeme colonne.
     * @param val la valeur a modifier. 
     */
    public void modifierMatrice(int i,int j,float val) {
        this.elements[i][j] = val;
    }
    
    /**
     * Remplir une case de la matrice a, a la ieme ligne et la jeme colonne avec la valeur val.
     * @param a la matrice.
     * @param i la ieme ligne.
     * @param j la jeme colonne.
     * @param val la valeur a inserer.
     */
    public void remplir_case(Matrice a,int i,int j,float val){
        a.elements[i][j]=val;
    }
    
    /**
     * Recuperer une valeur de la matrice a, a la ieme ligne et la jeme colonne.
     * @param a la matrice.
     * @param i la ieme ligne.
     * @param j la jeme colonne.
     * @return la valeur de la matrice a la ieme ligne et jeme colonne.
     */
    public float soustraire_val(Matrice a,int i,int j){
        return a.elements[i][j];
    }
    
    /**
     * Afficher les elements de la matrice ligne par ligne.
     */
    public void afficherMatrice() {
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                System.out.print(elements[i][j]+" | ");
            }
            System.out.println("");
        }  
    }
}
