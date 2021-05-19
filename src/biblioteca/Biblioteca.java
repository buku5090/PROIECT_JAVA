package biblioteca;

import contact.Contact;

public class Biblioteca {
    private String nume_biblioteca;
    private Contact contact;
    public Biblioteca(String nume_biblioteca, Contact contact)
    {
        this.nume_biblioteca=nume_biblioteca;
        this.contact=contact;
    }

    //getters
    public String get_nume_biblioteca(){return this.nume_biblioteca;}
    public Contact get_contact(){return this.contact;}

    //setters
    public void set_nume_biblioteca(String nume){this.nume_biblioteca=nume;}
    public void set_contact(Contact contact){this.contact=contact;}
}
