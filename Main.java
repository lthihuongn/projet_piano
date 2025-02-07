import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Partition partition = PartitionLoader.chargerPartition("./ressources/star_wars.txt");
        partition.afficher();
    }
        /*Application app = new Application();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une option : ");
            System.out.println("1 - Changer d'instrument");
            System.out.println("2 - Jouer une note");
            System.out.println("3 - Quitter");
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
                app.jouerNote(note);
            }
            else if (choix == 3) {
                app.fermer();
                break;
            }
        }

        scanner.close();
    }*/
}