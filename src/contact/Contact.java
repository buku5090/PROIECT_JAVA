package contact;

public class Contact {
    private String adresa;
    private String oras;
    private String program;
    private String nr_tel;

    public Contact(String adresa,String oras,String program,String nr_tel)
    {
        this.adresa="Strada Sublocotenent Erou Călin Cătălin 1";
        this.oras="Ploiesti";
        this.program="9:00-18:00";
        this.nr_tel="0244 521 900";
    }

    //getters
    public String get_adresa(){return this.adresa;}
    public String get_oras(){return this.oras;}
    public String get_program(){return this.program;}
    public String get_telefon(){return this.nr_tel;}

}
