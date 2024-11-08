/*420-SF2 – TP3
Groupe : 2 – mercredi & vendredi
Nom : Roseberry
Prénom : Steven
DA : 2440306
*/

import java.util.Random;

public class TP3F2RoseberryS2440306 {
    public TP3F2RoseberryS2440306() {

    }

    private int[][] creerTableau2DAleatoire(int nbLignes, int nbColonnes, int valMax, int valMin) {
        int[][] tableauAleatoire = new int[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                tableauAleatoire[i][j] = getNombreAleatoireEntreBorne(valMin, valMax);
            }
        }
        return tableauAleatoire;
    }

    public int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Maximum doit être plus grand que minimum");
        }
        Random r = new Random(); //Instanciation de la classe Random
        return r.nextInt((max - min) + 1) + min;
    }

    private int[] tronquerTableau(int[] tableauRecu, int nbValeursFinales) {
        int[] tableauTronque;
        tableauTronque = new int[nbValeursFinales];         // Le tableau tronqué aura la grosseur du nombre de valeurs
        for (int i = 0; i < nbValeursFinales; i++) {
            tableauTronque[i] = tableauRecu[i];
        }
        return tableauTronque;
    }

    private boolean estEnOrdreCroissant(int[] tableauRecu) {
        boolean isCroissant = false;

        if (tableauRecu.length == 1 || tableauRecu.length == 0) { // Vérifie par défault s'il y a 0 ou 1 valeur
            isCroissant = true;
        } else {
            for (int i = 0; i < tableauRecu.length; i++) {
                if (tableauRecu[i] > tableauRecu[i]) {
                    isCroissant = false;
                } else {
                    isCroissant = true;
                }
            }
        }
        return isCroissant;
    }

    public static int calculerGuerreDesNombres(int[][] guerres2D) {
        int resultatTotal = 0;

        for (int i = 0; i < guerres2D.length; i++) {         // Parcourt chaque "bataille"
            int soldatsPairs = 0;
            int soldatsImpairs = 0;

            for (int j = 0; j < guerres2D[i].length; j++) {  // Parcourt chaque nombre dans la bataille
                int nombre = guerres2D[i][j];                // L'utlisation d'un for-each aurait été bcp plus simple.
                if (nombre % 2 == 0) {
                    soldatsPairs += nombre;
                } else {
                    soldatsImpairs += nombre;
                }
            }

            int difference = soldatsPairs - soldatsImpairs;
            resultatTotal += difference;
        }
        return resultatTotal;
    }

    private int calculerGuerreDesNombres(int[] soldats) {    //Pour une seule bataille
        int soldatsPairs = 0;
        int soldatsImpairs = 0;
        int difference;

        for (int i = 0; i < soldats.length; i++) {
            if (i % 2 == 0) {
                soldatsPairs += i;
            } else {
                soldatsImpairs += i;
            }
        }
        difference = soldatsPairs - soldatsImpairs;
        return difference;
    }

    public static void main(String[] args) {
        new TP3F2RoseberryS2440306();
    }
}
