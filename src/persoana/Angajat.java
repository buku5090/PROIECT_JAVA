package persoana;

import persoana.Persoana;

public class Angajat extends Persoana {
    private int salariu;
    private String post;
    private int id_angajat;

    public Angajat(String nume, int salariu, String post,int id_angajat) {
        super(nume);
        this.salariu=salariu;
        this.post=post;
        this.id_angajat=id_angajat;
    }

    //getters
    public int get_salariu() {return salariu;}
    public String get_post()
    {
        return post;
    }
    public int get_id_angajat(){return id_angajat;}

    //setters
    public void set_id_angajat(int id_angajat){this.id_angajat=id_angajat;}
    public void set_salariu(int salariu)
    {
        this.salariu=salariu;
    }
    public void set_post(String post)
    {
        this.post=post;
    }
}
