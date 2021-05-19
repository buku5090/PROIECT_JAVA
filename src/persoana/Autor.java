package persoana;

import biblioteca.Carte;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Autor extends Persoana{

    public Autor(String nume,String tara_origine,float rating) throws IOException {
        super(nume);
        this.tara_origine=tara_origine;
        this.rating=rating;
    }
    //recenzie = suma notelor / nr recenzii
    private String tara_origine;
    private float rating;

    //getters
    public float get_rating() {return this.rating;}
    public String get_nume(){return this.nume;}
    public String get_tara_origine(){return this.tara_origine;}

    //setters
    public void set_rating(float rating){this.rating=rating;}
    public void set_nume(String nume){this.nume=nume;}
    public void set_tara_origine(String tara_origine){this.tara_origine=tara_origine;}

}
