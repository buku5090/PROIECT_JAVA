package menu;

import biblioteca.Carte;
import persoana.Angajat;
import persoana.Autor;
import persoana.Client;
import rating.Rating;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Initiere {
    private static Initiere single_instance=null;

    //initiere liste
    ArrayList<Client>clienti_lista=new ArrayList<Client>();
    ArrayList<Angajat>angajati_lista=new ArrayList<Angajat>();
    ArrayList<Carte>carti_lista=new ArrayList<Carte>();
    ArrayList<Carte>carti_imprumutate_lista=new ArrayList<Carte>();
    ArrayList<Rating>rating_carte_lista=new ArrayList<Rating>();
    ArrayList<Rating>rating_autor_lista=new ArrayList<Rating>();
    ArrayList<Autor>autori_lista=new ArrayList<Autor>();

    public static Initiere getInstance()
    {
        if(single_instance==null)
            single_instance=new Initiere();
        return single_instance;
    }

    private Initiere()
    {
        ;
    }

    public void initiere_liste() throws IOException {
        File fisier_citire_angajati=new File("src/angajati.csv");
        File fisier_citire_autori_biblioteca=new File("src/autori_biblioteca.csv");
        File fisier_citire_carti_biblioteca=new File("src/carti_biblioteca.csv");
        File fisier_citire_clienti=new File("src/clienti.csv");
        File fisier_citire_carti_imprumutate=new File("src/carti_imprumutate.csv");

        Scanner citire_data=new Scanner(fisier_citire_clienti);
        //citire din fisierul clienti
        while(citire_data.hasNextLine())
        {
            String data=citire_data.nextLine();
            String[] parti=data.split(",");

            Client client=new Client("","");
            client.set_cnp((parti[1]));
            client.set_nume(parti[0]);

            clienti_lista.add(client);
        }

        //citire din fisierul angajati
        citire_data=new Scanner(fisier_citire_angajati);
        while (citire_data.hasNextLine())
        {
            String data=citire_data.nextLine();
            String[] parti=data.split(",");

            Angajat angajat=new Angajat("",0,"",0);

            angajat.set_id_angajat(Integer.parseInt(parti[0]));
            angajat.set_nume(parti[1]);
            angajat.set_salariu(Integer.parseInt(parti[2]));
            angajat.set_post(parti[3]);

            angajati_lista.add(angajat);
        }

        //citire din fisierul carti dispobile
        citire_data=new Scanner(fisier_citire_carti_biblioteca);
        while(citire_data.hasNextLine())
        {
            String data=citire_data.nextLine();
            String[] parti=data.split(",");

            Rating rating=new Rating(0,0);
            Carte carte=new Carte(0,"","",0,0);

            carte.set_id(Integer.parseInt(parti[0]));
            carte.set_titlu(parti[1]);
            carte.set_autor(parti[2]);
            carte.set_an_aparitie(Integer.parseInt(parti[3]));

            rating.set_suma(Float.parseFloat(parti[4]));
            rating.set_nr(Float.parseFloat(parti[5]));

            float aux;
            aux=rating.get_suma()/rating.get_nr();
            carte.set_rating(aux);

            carti_lista.add(carte);
            rating_carte_lista.add(rating);
        }

        //citire din fisierul carti imprumutate
        citire_data=new Scanner(fisier_citire_carti_imprumutate);
        while(citire_data.hasNextLine())
        {
            String data=citire_data.nextLine();
            String[] parti=data.split(",");

            Carte carte=new Carte(0,"","",0,0);

            carte.set_id(Integer.parseInt(parti[0]));
            carte.set_titlu(parti[1]);
            carte.set_autor(parti[2]);

            carti_imprumutate_lista.add(carte);

        }

        //citire din fisierul autori
        citire_data=new Scanner(fisier_citire_autori_biblioteca);
        while (citire_data.hasNextLine())
        {
            String data=citire_data.nextLine();
            String[] parti=data.split(",");

            Rating rating=new Rating(0,0);
            Autor autor=new Autor("","",0);

            autor.set_nume(parti[0]);
            autor.set_tara_origine(parti[1]);
            rating.set_suma(Float.parseFloat(parti[2]));
            rating.set_nr(Float.parseFloat(parti[3]));
            float aux;
            aux=rating.get_suma()/rating.get_nr();
            autor.set_rating(aux);

            autori_lista.add(autor);
            rating_autor_lista.add(rating);
        }
    }

    //functii ce returneaza listele
    public ArrayList<Client> returnare_lista_clienti(){return clienti_lista;}
    public ArrayList<Angajat> returnare_lista_angajati(){return  angajati_lista;}
    public ArrayList<Carte> returnare_lista_carti(){return carti_lista;}
    public ArrayList<Carte> returnare_lista_carti_imprumutate(){return carti_imprumutate_lista;}
    public ArrayList<Rating> returnare_lista_rating_carti(){return rating_carte_lista;}
    public ArrayList<Rating> returnare_lista_rating_autori(){return rating_autor_lista;}
    public ArrayList<Autor> returnare_lista_autori(){return autori_lista;}
}
