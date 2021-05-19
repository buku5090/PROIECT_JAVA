package rating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rating {
    public Rating(float suma_rating,float nr_rating) throws FileNotFoundException {
        this.suma_rating=suma_rating;
        this.nr_rating=nr_rating;
    }
    //rating=suma rating/nr rating
    private float suma_rating;
    private float nr_rating;

    //getters
    public float get_suma(){return this.suma_rating;}
    public float get_nr(){return this.nr_rating;}

    //setters
    public void set_suma(float suma){this.suma_rating=suma;}
    public void set_nr(float nr){this.nr_rating=nr;}
}
