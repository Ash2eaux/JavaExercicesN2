import java.util.Random;
import java.util.Scanner;

public class Menu {
    // Exercice n°1
    // NE PAS EFFACER
    static int[] tabFrequence = new int[11];
    static String[] tabEntetes = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    // Exercice n°2
    // NE PAS EFFACER
    static int[][] tableau1Exo2 = new int[][]{{1, 2, 4}, {5, 6, 7}, {2, 1, 3}};
    static int[][] tableau2Exo2 = new int[][]{{2, 2, 4}, {1, 3, 5}, {1, 4, 8}};
    static int[][] tableauProduitExo2 = new int[3][3];

    public static void main(String[] args) {
        int choix;
        Scanner scanner = new Scanner(System.in);
        do {
            do {
                System.out.println("1 - Exercice 1");
                System.out.println("2 - Exercice 2");
                System.out.println("0 - Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
            } while (choix > 2 || choix < 0);

            switch (choix) {
                case 0:
                    System.out.println("Fin du programme");
                    break;
                    case 1:
                        Random random = new Random();
                        for (int i = 0; i < 20; i++) {
                            int de1 = random.nextInt(6)+1;
                            int de2 = random.nextInt(6)+1;
                            int somme = de1 + de2;
                            tabFrequence[somme - 2]++;
                        }

                        int freqMax = 0;
                        for (int frequence : tabFrequence) {
                            if (frequence > freqMax) {
                                freqMax = frequence;
                            }
                        }
                        // constructions des lignes
                        String[] tabLignes = new String[freqMax+1];
                        for (int i = 0; i < freqMax; i++) {
                            String lignes = "";
                            for (int j = 0; j < tabFrequence.length; j++) {
                                if (tabFrequence[j] >= (freqMax - i)) {
                                    lignes += "*\t";
                                } else {
                                    lignes += "\t";
                                }
                            }
                            tabLignes[i] = lignes;
                        }
                        // haut de 'lhistogramme avec entete
                        for (String entete : tabEntetes) {
                            System.out.print(entete + "\t");
                        }
                        System.out.println();
                        //eviter la valeur null
                        for (String ligne : tabLignes) {
                            if (ligne != null) {
                                System.out.println(ligne);
                            }
                        }
                        // bas du tableau fréquences
                        for (int frequences : tabFrequence) {
                            System.out.print(frequences + "\t");
                        }
                        System.out.println();
                        break;
                    case 2:
                        // méthode calcule d'une matrice 3*3 : C[i][j]=A[i][j]*B[i][j]
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                tableauProduitExo2[i][j] = 0;
                                for (int k = 0; k < 3; k++) {
                                    tableauProduitExo2[i][j] += tableau1Exo2[i][k] * tableau2Exo2[k][j];
                                }
                            }
                        }
                        for (int i = 0; i < tableauProduitExo2.length; i++) {
                            for (int j = 0; j < tableauProduitExo2[i].length; j++) {
                                System.out.print(tableauProduitExo2[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        break;
            }
        } while (choix != 0);
    }
}
