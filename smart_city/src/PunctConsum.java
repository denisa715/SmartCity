import java.util.ArrayList;
import java.util.List;

public class PunctConsum extends ElementUrban implements Monitorizabil {
    private String tip; // apa sau energie
    private List<Double> valoriConsumLunar;

    public PunctConsum(int id, String tip) {
        super(id);
        this.tip = tip;
        this.valoriConsumLunar = new ArrayList<>();
    }

    public void adaugaConsum(double val){
        valoriConsumLunar.add(val);
    }

    public double getConsumTotal() {
        double consumTotal = 0;
        for (double val : valoriConsumLunar) {
            consumTotal += val;
        }
        return consumTotal;
    }

    public String compUltimeleLuni() {
        if (valoriConsumLunar.size() < 2) {
            return "Date insuficiente pentru a determina consumul!";
        }

        double luna1 = valoriConsumLunar.get(valoriConsumLunar.size() - 1);
        double luna2 = valoriConsumLunar.get(valoriConsumLunar.size() - 2);

        double diferenta = luna1 - luna2;
        return "Diferenta: " + diferenta + " (" + (luna1 > luna2 ? "Crestere" : "Scadere") + ")";
    }

    public boolean consumNeobisnuit() {
        if(valoriConsumLunar.isEmpty()) {
            return false;
        }
        double media = getConsumTotal() / valoriConsumLunar.size();
        double ultimulConsum = valoriConsumLunar.get(valoriConsumLunar.size() - 1);

        return ultimulConsum > (media * 1.5);
    }

    @Override
    public String genereazaRaportScurt() {
        return descriere() + " | Consum total: " + getConsumTotal();
    }

    @Override
    public String descriere() {
        return "Punct consum ID " + id + " tip " + tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public List<Double> getValoriConsumLunar() {
        return valoriConsumLunar;
    }

    public void setValoriConsumLunar(List<Double> valoriConsumLunar) {
        this.valoriConsumLunar = valoriConsumLunar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}