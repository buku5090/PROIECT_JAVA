package persoana;

import persoana.Persoana;

public class Client extends Persoana {
    public Client(String nume, String cnp) {
        super(nume);
        this.cnp=cnp;
    }
    private String cnp;

    //getters
    public String get_cnp(){return cnp;}

    //setters
    public void set_cnp(String cnp){this.cnp=cnp;}
}
