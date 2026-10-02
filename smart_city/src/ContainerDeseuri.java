public class ContainerDeseuri extends ElementUrban implements Monitorizabil {
    private String locatie;
    private double capacitate;
    private double nivelUmplereProcent;

    public ContainerDeseuri(int id, String locatie, double capacitate, double nivelUmplereProcent) {
        super(id);
        this.locatie = locatie;
        this.capacitate = capacitate;
        setNivelUmplereProcent(nivelUmplereProcent);
    }

    public void setNivelUmplereProcent(double nivel) {
        if(nivel < 0 || nivel > 100){
            throw new ValoareInvalidaException("Nivelul trebuie sa fie intre 0 si 100!");
        }
        this.nivelUmplereProcent = nivel;
    }

    public double getNivelUmplereProcent() {
        return nivelUmplereProcent;
    }

    public String getLocatie() {
        return locatie;
    }

    @Override
    public String genereazaRaportScurt() {
        return  descriere()+  ": " + nivelUmplereProcent + "% plin.";
    }
    @Override
    public String descriere(){
        return "Container cu ID-ul " + id + " la " + locatie;
    }
}