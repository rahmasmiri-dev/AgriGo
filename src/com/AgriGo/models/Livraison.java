public class Livraison {
    private String statut;
    public Livraison(String statut) {
        this.statut = statut;
    }
    public void mettreAJourStatut(String nouveauStatut) {
        this.statut = nouveauStatut;
    }
    @Override
    public String toString() {
        return "Livraison : " + statut;
    }
}
