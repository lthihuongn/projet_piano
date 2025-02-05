import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une option : ");
            System.out.println("1 - Changer d'instrument");
            System.out.println("2 - Jouer une note");
            System.out.println("3 - Sauvegarder l'enregistrement");
            System.out.println("4 - Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Nettoyer la ligne

            if (choix == 1) {
                System.out.println("Instruments disponibles : Piano, Xylophone, Orgue, Violon");
                System.out.print("Entrez l'instrument : ");
                String instrument = scanner.nextLine();
                app.choisirInstrument(instrument);
            }
            else if (choix == 2) {
                System.out.print("Entrez une note (ex : C4, A#2) : ");
                String note = scanner.nextLine();
                System.out.print("Durée (en secondes) : ");
                double duree = scanner.nextDouble();
                scanner.nextLine(); // Nettoyer la ligne
                app.jouerNote(note, duree);
            }
            else if (choix == 3) {
                System.out.print("Entrez le nom du fichier pour sauvegarder : ");
                String nomFichier = scanner.nextLine();
                app.sauvegarderEnregistrement(nomFichier);
            }
            else if (choix == 4) {
                app.close();
                break;
            }
        }

        scanner.close();
    }
}