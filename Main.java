//biblioteca (sectiuni, carti, autori, cititori)
package com.company;
import java.util.*;
import static com.company.menu.meniu;

//biblioteca
///sectiuni
///carti
///autori - romani sau straini
///cititori - minori si adulti
class biblioteca{
    protected String locatie;
    public biblioteca(String l)
    {
        this.locatie=l;
    }
    public void citire_biblioteca()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti o locatie pentru biblioteca");
        in = new Scanner(System.in);
        String loc = in.nextLine();
        setter_biblioteca(loc);
    }
    public String getter_biblioteca()
    {
        return locatie;
    }
    public void setter_biblioteca(String l)
    {
        this.locatie=l;
    }
}

class sectiuni extends biblioteca{
    private char nr_sectiune;
    public sectiuni(String l, char n) {
        super(l);
        this.nr_sectiune=n;
    }
    public void citire_setiuni()
    {
        citire_biblioteca();
        System.out.println("Introduceti o sectiune a bibliotecii");
        Scanner in = new Scanner(System.in);
        in = new Scanner(System.in);
        char c = in.next().charAt(0);
        setter_sectiune(locatie,c);
    }
    public char getter_sectiune()
    {
        return nr_sectiune;
    }
    public void setter_sectiune(String l, char n)
    {
        setter_biblioteca(l);
        this.nr_sectiune=n;
    }
}
class carti extends biblioteca{
    private String tip;
    private int nr_pag;
    public carti(String l, String t, int nr){
        super(l);
        this.tip=t;
        this.nr_pag=nr;
    }
    public void citire_carti()
    {
        citire_biblioteca();
        System.out.println("Introduceti o carte");
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti tipul cartii: ");
        in = new Scanner(System.in);
        String tipul = in.nextLine();

        System.out.println("Introduceti nr de pagini al cartii: ");
        in = new Scanner(System.in);
        int nr_p = in.nextInt();

        setter_carte(locatie,tipul,nr_p);
    }
    public void setter_carte(String l, String tip, int nr)
    {
        setter_biblioteca(l);
        this.tip=tip;
        this.nr_pag=nr;
    }
    public int getter_nr_pag()
    {
        return this.nr_pag;
    }
    public String getter_tip()
    {
        return tip;
    }
}

class autori extends biblioteca{
    protected String nume, prenume;
    protected int varsta;
    public autori(String l, String n, String p, int v){
        super(l);
        this.nume=n;
        this.prenume=p;
        this.varsta=v;
    }

    public void citire_autori()
    {
        citire_biblioteca();
        System.out.println("Introduceti un autor");
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti numele autorului: ");
        in = new Scanner(System.in);
        String num = in.nextLine();

        System.out.println("Introduceti prenumele autorului: ");
        in = new Scanner(System.in);
        String prenum = in.nextLine();

        System.out.println("Introduceti varsta autorului: ");
        in = new Scanner(System.in);
        int var = in.nextInt();

        setter_autori(locatie,num,prenum,var);
    }

    public void setter_autori(String l, String n, String p, int v)
    {
        setter_biblioteca(l);
        this.varsta=v;
        this.nume=n;
        this.prenume=p;
    }
    public String getter_nume()
    {
        return nume;
    }
    public String getter_prenume()
    {
        return prenume;
    }
    public int getter_varsta()
    {
        return varsta;
    }
}

class autoriRomani extends autori{
    private String oras;
    public autoriRomani(String l, String n, String p, int v, String o) {
        super(l, n, p, v);
        this.oras=o;
    }
    public void setter_romani(String l, String n, String p, int v, String o)
    {
        this.locatie=l;
        this.nume=n;
        this.prenume=p;
        this.varsta=v;
        this.oras=o;
    }
    public String getter_oras()
    {
        return oras;
    }
}

class autoriStraini extends autori{
    private String tara_provenienta;
    public autoriStraini(String l, String n, String p, int v, String tara)
    {
        super(l,n,p,v);
        this.tara_provenienta=tara;
    }
    public void setter_straini(String l, String n, String p, int v, String tara)
    {
        this.locatie=l;
        this.nume=n;
        this.prenume=p;
        this.varsta=v;
        this.tara_provenienta=tara;
    }
    public String getter_tara()
    {
        return tara_provenienta;
    }

}

class cititori extends biblioteca{
    protected String preferinte;
    protected String numec;
    public cititori(String l, String pref, String numec)
    {
        super(l);
        this.preferinte=pref;
        this.numec=numec;
    }

    public void citire_cititori()
    {
        citire_biblioteca();
        System.out.println("Introduceti un cititor");
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti numele cititorului");
        in=new Scanner(System.in);
        String nc=in.nextLine();
        System.out.println("Introduceti preferinta cititorului in tipul de carti: ");
        in = new Scanner(System.in);
        String prefer = in.nextLine();

        setter_cititori(locatie,prefer,nc);
    }

    public String getter_preferinta()
    {
        return preferinte;
    }
    public String getter_nume(){return this.numec;}
    public void setter_cititori(String l, String pref, String nc)
    {
        this.locatie=l;
        this.preferinte=pref;
        this.numec=nc;
    }
}

class cititoriMinori extends cititori{
    private boolean permis_parinti;
    public cititoriMinori(String l, String pref, String nc, boolean permis)
    {
        super(l,pref,nc);
        this.permis_parinti=permis;
    }
    public void setter_minori(String l, String pref,String nc, boolean permis)
    {
        this.locatie=locatie;
        this.preferinte=pref;
        this.numec=nc;
        this.permis_parinti=permis;
    }
    public boolean getter_permis()
    {
        return permis_parinti;
    }
}

class cititoriAdulti extends cititori{
    private int nr_carti;
    public cititoriAdulti(String l, String pref, String nc, int nr_c)
    {
        super(l,pref,nc);
        this.nr_carti=nr_c;
    }
    public void setter_adulti(String l, String pref, String nc, int nr_c)
    {
        this.locatie=l;
        this.preferinte=pref;
        this.numec=nc;
        this.nr_carti=nr_c;
    }
    public int getter_nr_carti()
    {
        return nr_carti;
    }

}

class menu{
    public static ArrayList<autori> autori_lista=new ArrayList<autori>();
    public static ArrayList<cititori> cititori_lista=new ArrayList<cititori>();

    private static void alo()
    {
        System.out.println("Doriti sa va reintoarceti la meniu? (da/nu)");

        Scanner in = new Scanner(System.in);
        in = new Scanner(System.in);
        String alo2 = in.nextLine();

        if(alo2.equals("da"))
        {
            meniu();
        }

    }


    public static void meniu()
    {
        System.out.println("PROIECT JAVA - BIBLIOTECA - BUCURIE BOGDAN  - 253");
        System.out.println("1. Introduceti si afisati o biblioteca.");
        System.out.println("2. Introduceti si afisati o sectiune.");
        System.out.println("3. Introduceti si afisati o carte.");
        System.out.println("4. Introduceti si afisati un autor.");
        System.out.println("5. Introduceti si afisati un cititor.");
        System.out.println("6. Accesati documentele bibliotecii (4+5).");
        System.out.println("7. Afisati copiii cu permis de biblioteca.");//modificare carte
        System.out.println("8. Afisati cititorii adulti cu mai mult de 10 carti citite.");//
        System.out.println("9. Afisati autorii dintr-o anumita tara.");
        System.out.println("10. Afisati autorii dintr-un anumit oras.");
        System.out.println("Varianta aleasa de dvs. este: ");

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();


        switch (num)
        {
            case 1:
                System.out.println("Ati ales varianta 1!");
                biblioteca b=new biblioteca("");
                b.citire_biblioteca();
                System.out.println("Locatia bibliotecii este "+b.getter_biblioteca());
                alo();
                break;
            case 2:
                System.out.println("Ati ales varianta 2!");
                sectiuni sec=new sectiuni("",'a');
                sec.citire_setiuni();
                System.out.println("Sectiunea "+sec.getter_sectiune()+" se afla in biblioteca din "+sec.getter_biblioteca());
                alo();
                break;
            case 3:
                System.out.println("Ati ales varianta 3!");
                carti c=new carti("","",0);
                c.citire_carti();
                System.out.println("Tipul cartii este "+c.getter_tip()+", avand nr de pagini egal cu "+c.getter_nr_pag()+" si este in biblioteca "+c.getter_biblioteca());
                alo();
                break;
            case 4:
                System.out.println("Ati ales varianta 4!");
                System.out.println("Autorul este roman sau strain?");
                in = new Scanner(System.in);
                String origine = in.nextLine();

                if(origine.equals("roman"))
                {
                    autoriRomani ar=new autoriRomani("","","",0,"");
                    ar.citire_autori();
                    System.out.println("Introduceti orasul de provenienta al autorului:");
                    in = new Scanner(System.in);
                    String oras = in.nextLine();
                    ar.setter_romani(ar.locatie, ar.nume,ar.prenume,ar.varsta,oras);

                    System.out.println(ar.getter_nume()+" "+ar.getter_prenume()+", din "+ar.getter_oras()+", are varsta de "+ar.getter_varsta()+" de ani, iar cartile sale pot fi gasite in biblioteca din "+ar.getter_biblioteca());

                    autori_lista.add(ar);
                }
                else
                {
                    autoriStraini as=new autoriStraini("","","",0,"");
                    as.citire_autori();
                    System.out.println("Introduceti tara de provenienta a autorului:");
                    in = new Scanner(System.in);
                    String tara = in.nextLine();
                    as.setter_straini(as.locatie, as.nume,as.prenume,as.varsta,tara);

                    System.out.println(as.getter_nume()+" "+as.getter_prenume()+", din "+as.getter_tara()+", are varsta de "+as.getter_varsta()+" de ani, iar cartile sale pot fi gasite in biblioteca din "+as.getter_biblioteca());

                    autori_lista.add(as);
                }
                alo();
                break;
            case 5:
                System.out.println("Ati ales varianta 5!");
                System.out.println("Cititorul este minor sau adult?");
                in = new Scanner(System.in);
                String varsta = in.nextLine();

                if(varsta.equals("minor"))
                {
                    cititoriMinori cm=new cititoriMinori("","","",true);
                    cm.citire_cititori();
                    System.out.println("Cititorul are permis de biblioteca semnat de parinti?(da/nu)");
                    in = new Scanner(System.in);
                    String raspuns = in.nextLine();
                    if(raspuns.equals("da"))
                    {
                        cm.setter_minori(cm.locatie,cm.preferinte,cm.numec,true);
                        System.out.println(cm.numec+" prefera cartile de tip "+cm.getter_preferinta()+", mai ales pe cele din biblioteca din "+cm.getter_biblioteca());
                    }
                    else
                    {
                        cm.setter_minori(cm.locatie,cm.preferinte, cm.numec, false);
                        System.out.println("Atentie! "+cm.numec+" nu are permis semnat de parinti!");
                    }
                    cititori_lista.add(cm);
                }
                else
                {
                    cititoriAdulti ca=new cititoriAdulti("","","",0);
                    ca.citire_cititori();
                    System.out.println("Cate carti a citit aceasta persoana adulta?");
                    in = new Scanner(System.in);
                    int nr_car = in.nextInt();
                    ca.setter_adulti(ca.locatie, ca.preferinte, ca.numec, nr_car);

                    System.out.println(ca.numec+", ce a citit "+ca.getter_nr_carti()+" carti, prefera cartile de tip "+ca.getter_preferinta()+", mai ales pe cele din biblioteca din "+ca.getter_biblioteca());
                    cititori_lista.add(ca);
                }

                alo();
                break;
            case 6:
                System.out.println("Ati ales varianta 6!");

                Iterator<autori> i=autori_lista.iterator();
                Iterator<cititori> j=cititori_lista.iterator();
                System.out.println("Autori:");
                while(i.hasNext())
                {
                    autori aux;
                    aux=i.next();
                    System.out.println(aux.nume+" "+aux.prenume);
                }

                System.out.println("\nPreferintele cititorilor:");

                while(j.hasNext())
                {
                    cititori aux2;
                    aux2=j.next();
                    System.out.println(aux2.preferinte);
                }

                alo();
                break;
            case 7:
                for(Object iter : cititori_lista)
                {
                    if(iter instanceof cititoriMinori)
                        if(((cititoriMinori) iter).getter_permis()==true)
                            System.out.println(((cititoriMinori) iter).numec);
                }

                alo();
                break;
            case 8:

                for(Object iter:cititori_lista)
                {
                    if(iter instanceof cititoriAdulti)
                        if(((cititoriAdulti) iter).getter_nr_carti()>10)
                            System.out.println(((cititoriAdulti) iter).numec);
                }

                alo();
                break;
            case 9:
                System.out.println("Alegeti tara din care doriti sa afisati autorii");
                in=new Scanner(System.in);
                String alg=in.nextLine();

                for(Object iter:autori_lista)
                {
                    if(iter instanceof autoriStraini)
                    {
                        if(((autoriStraini) iter).getter_tara().equals(alg))
                            System.out.println(((autoriStraini) iter).getter_nume()+" "+((autoriStraini) iter).getter_prenume());
                    }
                }

                alo();
                break;
            case 10:
                System.out.println("Alegeti orasul din care doriti sa afisati autorii");
                in=new Scanner(System.in);
                String al=in.nextLine();

                for(Object iter:autori_lista)
                {
                    if(iter instanceof autoriRomani)
                    {
                        if(((autoriRomani) iter).getter_oras().equals(al))
                            System.out.println(((autoriRomani) iter).getter_nume()+" "+((autoriRomani) iter).getter_prenume());
                    }
                }

                alo();
                break;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        meniu();
    }
}

