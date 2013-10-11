/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.Scanner;

/**
 *
 * @author karim
 */
public class Matrice {
    
    private int nbLigne;
    private int nbColonne;
    private Float[][] elements;

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


    public int getNbLigne() {
            return nbLigne;
    }


    public void setNbLigne(int nbLigne) {
            this.nbLigne = nbLigne;
    }


    public int getNbColonne() {
            return nbColonne;
    }


    public void setNbColonne(int nbColonne) {
            this.nbColonne = nbColonne;
    }


    public Float[][] getElements() {
            return elements;
    }


    public void setElements(Float[][] elements) {
            this.elements = elements;
    }
    
    
    public void remplirMatrice() {
        Scanner scanf = new Scanner(System.in);
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                System.out.print("a"+(i+1)+(j+1)+" = ");
                this.elements[i][j] = scanf.nextFloat();
            }
        }
    }
    
    
    public void genererMatrice() {
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                this.elements[i][j] = (float)Math.round(Math.random()*100-50);
            }
        }
    }
    
    
    public void modifierMatrice(int i,int j,float val) {
        this.elements[i][j] = val;
    }
    
    
    public void afficherMatrice() {
        for(int i=0;i<nbLigne;i++) {
            for(int j=0;j<nbColonne;j++) {
                System.out.print(elements[i][j]+" | ");
            }
            System.out.println("");
        }  
    }
    
}
