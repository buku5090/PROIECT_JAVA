package persoana;

public class Persoana {
    public Persoana(String nume)
    {
        this.nume=nume;
    }
    protected String nume;

    //getters
    public String get_nume() {return nume;}

    //setters
    public void set_nume(String nume) {this.nume=nume;}
}
