import java.util.ArrayList;
import java.util.List;

public class SmartCity {

    private List<ElementUrban> elementeUrbane = new ArrayList<>();
    private List<Intersectie> intersectii = new ArrayList<>();
    private List<Parcare> parcari =  new ArrayList<>();
    private List<LinieAutobuz> liniiAutobuz = new ArrayList<>();
    private List<PunctConsum> puncteConsum = new ArrayList<>();
    private List<ContainerDeseuri> containere = new ArrayList<>();

    public void adaugaElementUrban(ElementUrban e) {
        elementeUrbane.add(e);
    }

    public void adaugaIntersectie(Intersectie i){
        intersectii.add(i);
        elementeUrbane.add(i);
    }

    public void adaugaParcare(Parcare p){
        parcari.add(p);
        elementeUrbane.add(p);
    }

    public void adaugaLinieAutobuz(LinieAutobuz l){
        liniiAutobuz.add(l);
        elementeUrbane.add(l);
    }

    public void adaugaPunctConsum(PunctConsum p){
        puncteConsum.add(p);
        elementeUrbane.add(p);
    }

    public void adaugaContainer(ContainerDeseuri c){
        containere.add(c);
        elementeUrbane.add(c);
    }

    public void getElementUrban(){
        for(ElementUrban e:elementeUrbane){
            System.out.println(e.descriere());
        }
    }
    public List<Intersectie> getIntersectii() {
        return intersectii;
    }

    public List<Parcare> getParcari() {
        return parcari;
    }

    public List<LinieAutobuz> getLiniiAutobuz() {
        return liniiAutobuz;
    }

    public List<PunctConsum> getPuncteConsum() {
        return puncteConsum;
    }

    public List<ContainerDeseuri> getContainere() {
        return containere;
    }

    public double calculeazaDistantaRuta(List<Double> distante){
        double total = 0;
        for(double d : distante){
            total += d;
        }
        return total;
    }

    public <T> void afiseazaInformatii(List<T> lista){
        for(T element : lista){
            System.out.println("Informatii: "+ element.toString());
        }
    }

    public <T extends Monitorizabil> void afiseazaRaportGeneric(List<T> lista, String titlu){
        System.out.println("\n");
        System.out.println("RAPORT GENERIC -> "+ titlu);
        for(T element : lista){
            System.out.println(element.genereazaRaportScurt());
        }
    }
}