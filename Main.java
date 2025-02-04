public class Main {
    public static void main(String[] args) {
        Partition partition = PartitionLoader.chargerPartition("ressources/mario1.txt");
        partition.afficher();
    }
}