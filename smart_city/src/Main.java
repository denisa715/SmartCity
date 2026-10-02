import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        SmartCity smartCity = new SmartCity();

        System.out.println("      SMART CITY   ");
        System.out.println("----------------------------");

        System.out.println("Initializare infrastructura orasului");
        try{
            //Intersectii
            System.out.println("Adaugare intersectii:");
            Intersectie i1 = new Intersectie(101, "Piata Unirii" , "INT-01", 60, 30, 4);
            Intersectie i2 = new Intersectie(102, "Bd.Eroilor", "INT-02", 90, 15, 2);
            smartCity.adaugaIntersectie(i1);
            smartCity.adaugaElementUrban(i1);
            System.out.println("   -> " + i1.descriere() + " | Semafor: " + i1.getTimpVerde() + "s Verde");

            smartCity.adaugaIntersectie(i2);
            smartCity.adaugaElementUrban(i2);
            System.out.println("   -> " + i2.descriere() + " | Semafor: " + i2.getTimpVerde() + "s Verde");

            System.out.println();

            //Parcari
            System.out.println("Adaugare parcari:");
            Parcare p1 = new Parcare(10, "Mall", 100, 98);
            Parcare p2 = new Parcare(11, "Parc", 50, 30);
            Parcare p3 = new Parcare(12, "Centru", 300, 150);
            smartCity.adaugaParcare(p1);
            smartCity.adaugaElementUrban(p1);
            System.out.println("   -> " + p1.genereazaRaportScurt());

            smartCity.adaugaParcare(p2);
            smartCity.adaugaElementUrban(p2);
            System.out.println("   -> " + p2.genereazaRaportScurt());

            smartCity.adaugaParcare(p3);
            smartCity.adaugaElementUrban(p3);
            System.out.println("   -> " + p3.genereazaRaportScurt());

            System.out.println();

            //Transport Public
            System.out.println("Adaugare linii transport:");
            LinieAutobuz l24 = new LinieAutobuz(24, 10, 40, 2);
            LinieAutobuz l35 = new LinieAutobuz(35, 15, 60, 5);
            LinieAutobuz lEx = new LinieAutobuz(46, 8, 25, 0);
            smartCity.adaugaLinieAutobuz(l24);
            System.out.println("   ->Linia " + l24.getNumarLinie() + "(Durata: " + l24.getTimpTotalMinute() + " min)");

            smartCity.adaugaLinieAutobuz(l35);
            System.out.println("   ->Linia " + l35.getNumarLinie() + "(Durata: " + l35.getTimpTotalMinute() + " min)");

            smartCity.adaugaLinieAutobuz(lEx);
            System.out.println("   ->Linia " + lEx.getNumarLinie() + "(Durata: " + lEx.getTimpTotalMinute() + " min)");

            System.out.println();

            //Utilitati si deseuri
            System.out.println("Adaugare utilitati si puncte colectare:");
            PunctConsum ap1 = new PunctConsum(19, "Energie Electrica");
            ap1.adaugaConsum(350);
            ap1.adaugaConsum(380);
            ap1.adaugaConsum(900);//consum neobisnuit de mare

            smartCity.adaugaPunctConsum(ap1);
            smartCity.adaugaElementUrban(ap1);
            System.out.println("   -> " + ap1.descriere() + " (Consum total inregistrat: " + ap1.getConsumTotal() + ")");

            ContainerDeseuri c1 = new ContainerDeseuri(401, "Str. Unirii", 1000, 95.5);
            ContainerDeseuri c2 = new ContainerDeseuri(402, "Str. Observatorului", 5000, 20.0);
            smartCity.adaugaContainer(c1);
            smartCity.adaugaElementUrban(c1);
            System.out.println("   -> " + c1.genereazaRaportScurt());

            smartCity.adaugaContainer(c2);
            smartCity.adaugaElementUrban(c2);
            System.out.println("   -> " + c2.genereazaRaportScurt());

            System.out.println("Infrastucura orasului a fost creata");

            System.out.println();
        } catch (Exception e) {
            System.out.println("Eroare la initializare: " + e.getMessage());
        }

        //Parcari si execptii
        System.out.println("Simulare flux auto si parcari si exeprtii");

        Parcare parcareMall = smartCity.getParcari().get(0); //Mall Central (198/200)

        try{
            System.out.println("Stare initiala Mall: " + parcareMall.genereazaRaportScurt());

            System.out.println("-> Intra o masina");
            parcareMall.intraMasina(); //parcarea devine 199

            System.out.println("-> Intra a doua masina");
            parcareMall.intraMasina(); //parcarea devine 200 adica e FULL
            System.out.println("Stare curenta: " + parcareMall.getLocuriOcupate() + "/" + parcareMall.getCapacitate());

            System.out.println("-> Intra a treia masina");
            parcareMall.intraMasina(); //exceptie parcarea este deja plina

        }catch(ValoareInvalidaException e){
            System.out.println("Exceptie prinsa: " + e.getMessage());
            System.out.println("Soferul celei de-a treia masini a fost redirectionat catre cea mai apropiata parcare");
        }

        System.out.println("\n-> Topul parcarilor aglomerate:");
        Collections.sort(smartCity.getParcari());
        //le afisam pe cele mai pline primele
        Collections.reverse(smartCity.getParcari());

        for(Parcare p : smartCity.getParcari()){
            System.out.printf("  -%s: %.1f%% ocupat\n", p.getNume(), p.gradOcupare());
        }

        //monitorizare si metode generice
        System.out.println("   Monitorizare si rapoarte   ");
        smartCity.afiseazaRaportGeneric(smartCity.getContainere(), "DESEURI");
        smartCity.afiseazaRaportGeneric(smartCity.getParcari(), "PARCARI");

        System.out.println();
        System.out.println();

        //transport public si calcul rute
        System.out.println("Optimizare transport public");

        smartCity.getLiniiAutobuz().sort(LinieAutobuz.comparatorDupaTimp);
        System.out.println("-> Linii de autobuz sortate dupa durata traseului:");
        for(LinieAutobuz l : smartCity.getLiniiAutobuz()){
            System.out.println("  Linia " + l.getNumarLinie() + ": " + l.getTimpTotalMinute() + " min");
        }

        //testare exceptie statie invalida
        try{
            LinieAutobuz lTest = smartCity.getLiniiAutobuz().get(0);
            System.out.println("-> Incercare actualizare statie curenta la valoarea 100");
            lTest.setStatieCurenta(100);
        }catch(ValoareInvalidaException e){
            System.out.println("Eroare GPS: " + e.getMessage());
        }

        System.out.println();
        System.out.println();

        //Calcul ruta deseuri
        System.out.println("Calculare ruta salubritate:");
        List<Double> distantePuncte = new ArrayList<>();
        distantePuncte.add(2.5);
        distantePuncte.add(1.8);
        distantePuncte.add(4.2);
        System.out.println("-> Distanta totala ruta salubritate: " + smartCity.calculeazaDistantaRuta(distantePuncte) + " km");

        //mentenanta si alerta consum
        System.out.println("\nMentenanta si alerte inteligente");

        //Verificam punctele de consum
        for(PunctConsum pc : smartCity.getPuncteConsum()) {
            if(pc.consumNeobisnuit()) {
                System.out.println("Alerta: Consum neobisnuit detectat la " + pc.descriere());
                System.out.println("  ->" + pc.compUltimeleLuni());
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("Verificare echipamente defecte:");

        for(Intersectie i : smartCity.getIntersectii()) {
            i.efectueazaMentenanta();
        }
    }
}