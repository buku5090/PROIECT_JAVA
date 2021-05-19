package menu;

import biblioteca.Biblioteca;
import biblioteca.Carte;
import contact.Contact;
import persoana.Angajat;
import persoana.Autor;
import persoana.Client;
import rating.Rating;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Servicii {
    private Servicii(){
        ;
    }

    private static Servicii single_instance=null;

    public static Servicii getInstance()
    {
        if(single_instance==null)
            single_instance=new Servicii();
        return single_instance;
    }

    //public

    public LocalDateTime get_timp()
    {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }


    public void afisare() throws IOException {
        System.out.println("\nBIBLIOTECA NATIONALA NICOLAE IORGA\n");
        System.out.println("1. Fa-ti abonament!");
        System.out.println("2. Aflati daca biblioteca este deschisa.");
        System.out.println("3. Afisati angajatii bibliotecii si posturile acestora.");
        System.out.println("4. Afisati cartile disponibile, dupa rating.");
        System.out.println("5. Acorda un rating unei carti!");
        System.out.println("6. Imprumuta o carte.");
        System.out.println("7. Returneaza o carte.");
        System.out.println("8. Afisati autorii si cartile scrise de acestia.");
        System.out.println("9. Cautati o carte, dupa nume, in biblioteca.");
        System.out.println("10. Depuneti o plangere.");
        System.out.println("11. Contact.");

        //formatare data


        //initiere din pachetul initiere
        Initiere initiere=Initiere.getInstance();
        initiere.initiere_liste();

        //initiere liste
        ArrayList<Client> clienti_lista=new ArrayList<Client>();
        ArrayList<Angajat> angajati_lista=new ArrayList<Angajat>();
        ArrayList<Carte>carti_lista=new ArrayList<Carte>();
        ArrayList<Carte>carti_imprumutate_lista=new ArrayList<Carte>();
        ArrayList<Rating>rating_carte_lista=new ArrayList<Rating>();
        ArrayList<Rating>rating_autor_lista=new ArrayList<Rating>();
        ArrayList<Autor>autori_lista=new ArrayList<Autor>();

        //scriere in fisiere
        FileWriter fisier_scriere_clienti=new FileWriter("src/clienti.csv",true);
        FileWriter fisier_scriere_plangeri=new FileWriter("src/plangeri.csv",true);
        FileWriter fisier_scriere_carti=new FileWriter("src/carti_biblioteca.csv",true);
        FileWriter fisier_scriere_carti_imprumutate=new FileWriter("src/carti_imprumutate.csv",true);
        FileWriter fisier_logs = new FileWriter("src/logs.txt",true);

        //introducere date in liste
        clienti_lista= initiere.returnare_lista_clienti();
        angajati_lista=initiere.returnare_lista_angajati();
        carti_lista= initiere.returnare_lista_carti();
        carti_imprumutate_lista= initiere.returnare_lista_carti_imprumutate();
        rating_carte_lista= initiere.returnare_lista_rating_carti();
        rating_autor_lista= initiere.returnare_lista_rating_autori();
        autori_lista=initiere.returnare_lista_autori();

        //retin alegerea user-ului
        int alg=0;

        //meniul
        do{
            //alegere optiune
            System.out.println("_________________________________________________________________________________");
            System.out.print("Alegeti o varianta:\n");
            Scanner alegere=new Scanner(System.in);
            alg=alegere.nextInt();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            if(alg==1)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Fa-ti un abonament'\n");

                //citire
                System.out.println("Introdu CNP-ul:");
                Scanner myscanner=new Scanner(System.in);
                String cnp=myscanner.nextLine();

                Client aux=new Client("","");
                int ok=1;

                //verific daca exista deja cnp-ul in baza de date
                for(int i=0;i<clienti_lista.size();i++)
                {
                    aux=clienti_lista.get(i);
                    if(cnp.equals(aux.get_cnp()))
                    {
                        System.out.println("Acest CNP exista deja in baza de date!");
                        fisier_logs.write(dtf.format(get_timp())+" Utilizatorul a introdus un user deja existent\n");
                        ok=0;
                    }
                }
                if(ok==1)
                {
                    aux.set_cnp(cnp);
                    System.out.println("Introduceti numele dvs.:");
                    myscanner=new Scanner(System.in);
                    String nume=myscanner.nextLine();
                    aux.set_nume(nume);

                    //adaugare in lista
                    clienti_lista.add(aux);

                    //scriere in fisier
                    fisier_scriere_clienti.write("\n"+nume+","+cnp);
                    fisier_scriere_clienti.close();

                    System.out.println("Felicitari! Ti-ai creat un abonament!");
                    fisier_logs.write(dtf.format(get_timp())+" Utilizatorul a creat un abonament cu numele "+nume+" si cnp-ul "+cnp+"\n");
                }

            }
            if(alg==2)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Aflati daca biblioteca este deschisa'\n");

                Calendar cal=Calendar.getInstance();
                SimpleDateFormat sdf=new SimpleDateFormat("HH");

                int ora= Integer.parseInt(sdf.format(cal.getTime()));
                if(ora>=9&&ora<=18)
                {
                    System.out.println("Biblioteca este deschisa!");
                    fisier_logs.write(dtf.format(get_timp())+" Biblioteca a fost deschisa\n");
                }
                else {
                    System.out.println("Biblioteca este inchisa! Incercati maine!");
                    fisier_logs.write(dtf.format(get_timp())+" Biblioteca a fost inchisa\n");
                }
            }
            if(alg==3)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Afisati angajatii bibliotecii si posturile acestora'\n");
                Angajat aux=new Angajat("",0,"",0);
                System.out.println("Angajatii bibliotecii sunt:\n");
                for(int i=0;i<angajati_lista.size();i++)
                {
                    aux=angajati_lista.get(i);
                    System.out.println(aux.get_nume()+" - "+aux.get_post());
                }
            }
            if(alg==4)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Afisati cartile disponibile, dupa rating'\n");
                System.out.println("Cartile disponile sunt:\n");
                Collections.sort(carti_lista);

                for(int i=0;i<carti_lista.size();i++) {
                    int ok = 1;//contor ce retine 1 pt adv si 0 pt fals, pp ca initial este adv
                    Carte carte = new Carte(0, "", "", 0, 0);
                    Carte aux = new Carte(0, "", "", 0, 0);
                    carte = carti_lista.get(i);

                    for (int j = 0; j < carti_imprumutate_lista.size(); j++) {
                        aux = carti_imprumutate_lista.get(j);
                        if (carte.get_id_carte() == aux.get_id_carte()) {
                            ok = 0;//daca sunt egale, inseamna ca este fals, cartea
                            // nu este dispobila deoarece este imprumutata
                        }
                    }
                    if (ok == 1) {
                        System.out.println("-> '" + carte.get_titlu() + "' - " + carte.get_autor() + ", scrisa in anul " + carte.get_an_ap());
                        System.out.print("-----> Rating: ");
                        System.out.printf("%.2f",carte.get_rating());
                        System.out.print("/10\n\n");
                    }
                }
            }
            if(alg==5)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Acorda un rating unei carti'\n");

                int ok=1;
                System.out.println("Oferiti o nota unei carti citite! (0-10)");
                System.out.println("Care este numele cartii pe care doriti sa o evaluati?");
                Scanner myScanner=new Scanner(System.in);
                String titlu=myScanner.nextLine();
                float nota=0;

                fisier_logs.write(dtf.format(get_timp())+" Cartea cautata: "+titlu+"\n");

                Carte carte_aux=new Carte(0,"","",0,0);
                Rating raiting_aux=new Rating(0,0);

                for(int i=0;i<carti_lista.size();i++)
                {
                    carte_aux=carti_lista.get(i);
                    if(titlu.equals(carte_aux.get_titlu()))
                    {
                        System.out.println("Ce rating oferiti cartii? (0-10)");
                        myScanner=new Scanner(System.in);
                        nota=myScanner.nextFloat();

                        fisier_logs.write(dtf.format(get_timp())+" Rating acordat: "+nota+"\n");

                        raiting_aux=rating_carte_lista.get(i);
                        raiting_aux.set_suma(raiting_aux.get_suma()+nota);
                        raiting_aux.set_nr(raiting_aux.get_nr()+1);

                        rating_carte_lista.set(i,raiting_aux);//introduc noua valoarea in lista

                        carte_aux.set_rating(raiting_aux.get_suma()/raiting_aux.get_nr());
                        carti_lista.set(i,carte_aux);

                        ok=0;
                    }
                }
                if(ok==0)
                {
                    FileWriter fisier_golire=new FileWriter("src/carti_biblioteca.csv");
                    fisier_golire.close();
                    for(int i=0;i<carti_lista.size();i++)
                    {
                        raiting_aux=rating_carte_lista.get(i);
                        carte_aux=carti_lista.get(i);
                        fisier_scriere_carti.write(carte_aux.get_id_carte()+","+carte_aux.get_titlu()+","+carte_aux.get_autor()+","+carte_aux.get_an_ap()+","+raiting_aux.get_suma()+","+raiting_aux.get_nr()+"\n");

                    }
                    fisier_scriere_carti.close();
                    System.out.println("Felicitari! Ati oferit nota "+nota+" cartii '"+titlu+"'!");
                }
                else {
                    System.out.println("Cartea nu a putut fi gasita!");
                    fisier_logs.write(dtf.format(get_timp())+" Cartea nu a putut fi gasita\n");
                }
            }
            if(alg==6)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Imprumuta o carte'\n");
                System.out.println("Introduceti numele cartii:");
                Scanner myScanner=new Scanner(System.in);
                String titlu=myScanner.nextLine();
                int ok=1;//contor pt a verifica daca cartea este imprumutata
                int ok2=1;//contor pt a verifica daca cartea exista
                fisier_logs.write(dtf.format(get_timp())+" Utilizatorul a introdus ca nume pentru carte "+titlu+"\n");
                Carte carte_aux=new Carte(0,"","",0,0);
                Carte carte2_aux=new Carte(0,"","",0,0);

                for(int i=0;i<carti_imprumutate_lista.size();i++)
                {
                    carte_aux=carti_imprumutate_lista.get(i);
                    if(titlu.equals(carte_aux.get_titlu()))
                    {
                        System.out.println("Cartea este deja imprumutata!");
                        fisier_logs.write(dtf.format(get_timp())+" Cartea ceruta este imprumutata"+"\n");
                        ok=0;
                        ok2=0;
                    }
                }

                if(ok==1)
                {
                    for(int i=0;i<carti_lista.size();i++)
                    {
                        carte2_aux=carti_lista.get(i);
                        if(titlu.equals(carte2_aux.get_titlu()))
                        {
                            System.out.println("Cartea este disponibila! Puteti sa o ridicati oricand intre orele 9:00-18:00!");
                            fisier_logs.write(dtf.format(get_timp())+" Cartea ceruta este disponibila si a fost imprumuatata"+"\n");
                            fisier_scriere_carti_imprumutate.write(carte2_aux.get_id_carte()+","+carte2_aux.get_titlu()+","+carte2_aux.get_autor()+"\n");
                            fisier_scriere_carti_imprumutate.close();
                            ok2=0;
                        }
                    }
                }
                if(ok2==1) {
                    System.out.println("Cartea nu exista in biblioteca noastra!");
                    fisier_logs.write(dtf.format(get_timp())+" Cartea ceruta nu exista"+"\n");
                }
            }
            if(alg==7)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Returneaza o carte'\n");
                System.out.println("Introduceti numele cartii:");
                Scanner myScanner=new Scanner(System.in);
                String titlu=myScanner.nextLine();

                fisier_logs.write(dtf.format(get_timp())+" Utilizatorul a introdus ca nume pentru carte "+titlu+"\n");

                int ok=1;

                Carte carte_aux=new Carte(0,"","",0,0);

                for(int i=0;i<carti_imprumutate_lista.size();i++)
                {
                    carte_aux=carti_imprumutate_lista.get(i);
                    if(titlu.equals(carte_aux.get_titlu()))
                    {
                        fisier_logs.write(dtf.format(get_timp())+" Cartea a fost returnata\n");
                        System.out.println("Carte returnata!");
                        carti_imprumutate_lista.remove(i);
                        ok=0;
                    }
                }
                if(ok==0)
                {
                    FileWriter fisier_golire=new FileWriter("carti_imprumutate.csv");
                    fisier_golire.write("");
                    fisier_golire.close();

                    //for
                }
                else
                {
                    System.out.println("Cartea nu a fost gasita!\n");
                    fisier_logs.write(dtf.format(get_timp())+" Cartea nu a fost gasita\n");
                }

            }
            if(alg==8)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Afisati autorii si cartile scrise de acestia'\n");

                Autor autor=new Autor("","",0);
                Carte carte_aux=new Carte(0,"","",0,0);
                for(int i=0;i<autori_lista.size();i++)
                {
                    autor=autori_lista.get(i);
                    System.out.print(autor.get_nume()+", nascut in "+autor.get_tara_origine()+" - ");
                    System.out.printf("%.2f",autor.get_rating());
                    System.out.print("/10\n");

                    for(int j=0;j< carti_lista.size();j++)
                    {
                        carte_aux=carti_lista.get(j);
                        if(carte_aux.get_autor().equals(autor.get_nume()))
                        {
                            System.out.println("----> '"+carte_aux.get_titlu()+"'");
                        }
                    }
                    System.out.println("");
                }
            }
            if(alg==9)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Cautati o carte, dupa nume, in biblioteca'\n");

                System.out.println("Introduceti numele cartii:");
                Scanner myScanner=new Scanner(System.in);
                String titlu=myScanner.nextLine();
                fisier_logs.write(dtf.format(get_timp())+" Utilizatorul a introdus ca nume pentru carte: "+titlu+"\n");
                Carte carte_aux=new Carte(0,"","",0,0);
                Carte carte2_aux=new Carte(0,"","",0,0);
                int ok=1;
                int ok2=1;
                for(int i=0;i<carti_lista.size();i++)
                {
                    carte_aux=carti_lista.get(i);
                    if(titlu.equals(carte_aux.get_titlu()))
                    {
                        ok=0;
                    }
                }
                if(ok==1) {
                    System.out.println("Cartea nu exista in biblioteca noastra!");
                    fisier_logs.write(dtf.format(get_timp())+" Cartea ceruta nu exista\n");
                }
                else
                {
                    for(int i=0;i<carti_imprumutate_lista.size();i++)
                    {
                        carte2_aux=carti_imprumutate_lista.get(i);
                        if(titlu.equals(carte2_aux.get_titlu()))
                        {
                            ok2=0;
                        }
                    }
                    if(ok2==1) {
                        System.out.println("Cartea este disponibila!");
                        fisier_logs.write(dtf.format(get_timp())+" Cartea este disponibila\n");
                    }
                    else {
                        System.out.println("Detinem aceasta carte, dar este momentat indispobila!");
                        fisier_logs.write(dtf.format(get_timp())+" Cartea este momentan indisponibila\n");
                    }
                }
            }
            if(alg==10)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Depuneti o plangere'\n");
                System.out.println("\nVa rugam, descrieti-ne problema!");
                Scanner myScanner=new Scanner(System.in);
                String plangere=myScanner.nextLine();

                fisier_scriere_plangeri.write(plangere +","+ LocalDate.now()+"\n");
                fisier_scriere_plangeri.close();
                fisier_logs.write(dtf.format(get_timp())+" Utilizatorul a depus o plangere - "+plangere+"\n");
                System.out.println("Va multumim! Vom incerca sa rememdiem problema cat mai rapid!");
            }
            if(alg==11)
            {
                fisier_logs.write(dtf.format(get_timp())+" A fost aleasa optiunea 'Contact'\n");
                Contact contact=new Contact("","","","");
                Biblioteca biblioteca = new Biblioteca("",contact);
                contact=biblioteca.get_contact();
                biblioteca.set_nume_biblioteca("Biblioteca Nationala Nicolae Iorga");
                System.out.println("Informatii "+biblioteca.get_nume_biblioteca());
                System.out.println("Adresa: " +contact.get_adresa()+", din orasul "+contact.get_oras());
                System.out.println("Numar de telefon: "+contact.get_telefon());
                System.out.println("Biblioteca este deshisa dupa programul: "+contact.get_program());
            }

        }while(alg > 0 && alg < 12);
        fisier_logs.write("\n__________________________________________________\n\n");
        fisier_logs.close();
    }
}
