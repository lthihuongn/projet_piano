class Application {
    private Record enregistrement;
    private String instrumentActuel;

    public Application() {
        this.enregistrement = new Record("melodie.txt");
        this.instrumentActuel = "Piano"; // Instrument par défaut
    }

    public void choisirInstrument(String instrument) {
        this.instrumentActuel = instrument;
        System.out.println("Instrument sélectionné : " + instrumentActuel);
    }

    public void jouerNote(String note, double duree) {
        enregistrement.addNote(instrumentActuel, new Note(note, duree));
    }

    public void sauvegarderEnregistrement(String nomFichier) {
        enregistrement.setFileName(nomFichier);
        enregistrement.close();
    }

    public void close() {
        System.out.println("Fermeture de l'application.");
    }
}
