

public class Admin extends Utilisateur {
    private String role;

    public Admin(int id, String nom, String prenom, String email, String motDePasse, String role) {
        super(id, nom, prenom, email, motDePasse);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "role='" + role + '\'' +
                "} " + super.toString();
    }
}