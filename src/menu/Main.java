package menu;

import persoana.Client;
import rating.Rating;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //creez un obiect de tip Servicii, clasa singleton
        Servicii serviciu=Servicii.getInstance();
        serviciu.afisare();
    }
}
