import java.util.Comparator;

public class LinieAutobuz extends ElementUrban implements Monitorizabil {
    private int numarStatii;
    private int timpTotalMinute;
    private int statieCurenta;

    public LinieAutobuz(int numarLinie, int numarStatii, int timpTotalMinute, int statieCurenta) {
        super(numarLinie);
        this.numarStatii = numarStatii;
        this.timpTotalMinute = timpTotalMinute;
        this.statieCurenta = statieCurenta;
    }

    public int getNumarLinie() {
        return id;
    }

    public int getNumarStatii() {
        return numarStatii;
    }
    public void setNumarStatii(int numarStatii) {
        this.numarStatii = numarStatii;
    }

    public int getTimpTotalMinute() {
        return timpTotalMinute;
    }
    public void setTimpTotalMinute(int timpTotalMinute) {
        this.timpTotalMinute = timpTotalMinute;
    }

    public int getStatieCurenta() {
        return statieCurenta;
    }
    public void setStatieCurenta(int statieCurenta) throws ValoareInvalidaException {
        if(statieCurenta < 0 || statieCurenta > numarStatii){
            throw new ValoareInvalidaException("Statie insexistenta pe acest traseu!");
        }

        this.statieCurenta = statieCurenta;
    }

    public double estimareSosire(){
        return timpTotalMinute * (1 -(double)this.statieCurenta / numarStatii);
    }

    public static Comparator<LinieAutobuz> comparatorDupaTimp = new Comparator<LinieAutobuz>() {
        @Override
        public int compare(LinieAutobuz l1, LinieAutobuz l2) {
            return Integer.compare(l1.getTimpTotalMinute(), l2.getTimpTotalMinute());
        }
    };

    @Override
    public String descriere() {
        return "Linie autobuz " + id;
    }

    @Override
    public String genereazaRaportScurt() {
        return "Linia " + id + " cu " + numarStatii + " statii, timp total " + timpTotalMinute + " minute";
    }
}