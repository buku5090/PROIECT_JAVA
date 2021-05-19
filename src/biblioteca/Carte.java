package biblioteca;

import java.io.FileNotFoundException;
import java.lang.Float;

public class Carte implements Comparable<Carte>{
    private String titlu;
    private String autor;
    private int an_aparitie;
    private float rating;
    private int id_carte;
    public Carte(int id_carte, String titlu, String autor, int an_aparitie, float rating) throws FileNotFoundException {
        this.titlu=titlu;
        this.an_aparitie=an_aparitie;
        this.autor=autor;
        this.rating=rating;
        this.id_carte=id_carte;
    }

    //getters
    public String get_titlu(){return titlu;}
    public int get_an_ap(){return an_aparitie;}
    public int get_id_carte(){return id_carte;}
    public float get_rating() {return rating;}
    public String get_autor() {return autor;}

    //setters
    public void set_titlu(String titlu){this.titlu=titlu;}
    public void set_an_aparitie(int an_ap){this.an_aparitie=an_ap;}
    public void set_rating(float rating){this.rating=rating;}
    public void set_autor(String autor){this.autor=autor;}
    public void set_id(int id){this.id_carte=id;}


    @Override
    public int compareTo(Carte carte) {
        int ok=0;

        if(this.get_rating()>carte.get_rating())
            ok=-1;
        if(this.get_rating()<carte.get_rating())
            ok=1;

        return ok;

        //return this.get_an_ap()-carte.get_an_ap();
    }

    @Override
    public String toString()
    {
        return "xd";
    }
}
