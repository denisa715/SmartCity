import java.util.ArrayList;

public class Intersectie extends ElementUrban implements Mentenabil{
    private String nume;
    private String cod;
    private int timpRosu;
    private int timpVerde;
    private int numarBenzi;

    public Intersectie(int id,String nume, String cod, int timpRosu, int timpVerde, int numarBenzi) {
        super(id);
        this.nume = nume;
        this.cod = cod;
        this.timpRosu = timpRosu;
        this.timpVerde = timpVerde;
        this.numarBenzi = numarBenzi;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getTimpRosu() {
        return timpRosu;
    }
    public void setTimpRosu(int timpRosu) {
        this.timpRosu = timpRosu;
    }

    public int getTimpVerde() {
        return timpVerde;
    }
    public void setTimpVerde(int timpVerde) {
        this.timpVerde = timpVerde;
    }

    public int getNumarBenzi() {
        return numarBenzi;
    }
    public void setNumarBenzi(int numarBenzi) {
        this.numarBenzi = numarBenzi;
    }

    @Override

    public String toString() {
        return "Intersectia se numeste " + getNume() + ", are codul "+ getCod() +
                ", are " + getNumarBenzi() + " benzi" + ", timpul cat a stat: verde->"+
                getTimpVerde() + ", rosu-> " + getTimpRosu();
    }

    @Override
    public String descriere() {
        return "Intersectia " + nume + " (ID: " + id + ")";
    }

    @Override
    public boolean necesitaReparatii() {
        return false;
    }

    @Override
    public void efectueazaMentenanta() {
        System.out.println("Semafor verificat!");
    }
}