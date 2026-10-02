public class Parcare extends ElementUrban implements Monitorizabil, Comparable<Parcare> {
    private String nume;
    private int capacitate;
    private int locuriOcupate;

    public Parcare(int id, String nume, int capacitate, int locuriOcupate) {
        super(id);
        this.nume = nume;
        this.capacitate = capacitate;
        this.locuriOcupate = locuriOcupate;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCapacitate() {
        return capacitate;
    }
    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public int getLocuriOcupate() {
        return locuriOcupate;
    }
    public void setLocuriOcupate(int locuriOcupate) {
        this.locuriOcupate = locuriOcupate;
    }

    public void intraMasina() throws ValoareInvalidaException{
        if(locuriOcupate == capacitate){
            throw new ValoareInvalidaException("Parcarea este plina!");
        }
        locuriOcupate++;
    }

    public void ieseMasina() throws ValoareInvalidaException{
        if(locuriOcupate == 0){
            throw new ValoareInvalidaException("Parcarea este goala!");
        }
        locuriOcupate--;
    }

    public double gradOcupare(){
        return ((double)locuriOcupate / capacitate) * 100;
    }

    public String genereazaRaportScurt(){
        return "Parcarea " + getNume() + " are capacitatea " + getCapacitate() +
                " si " + getLocuriOcupate() + " locuri ocupate";
    }

    @Override
    public int compareTo(Parcare o) {
        return Double.compare(this.gradOcupare(), o.gradOcupare());
    }

    @Override
    public String descriere() {
        return "Parcare " + nume + " (ID: " + id + ")";
    }
}