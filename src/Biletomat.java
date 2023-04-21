import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

interface Bilet {
    String toString();
}

class BiletNormalny implements Bilet {
    public String toString() {
        return "Bilet normalny";
    }
}

class BiletUlgowy implements Bilet {
    public String toString() {
        return "Bilet ulgowy";
    }
}

interface Serwis {
    void napraw();
    void wypiszLog();
}

interface Pieniadz {
    void odejmijKwote(double kwota);
}

public class Biletomat {
    private static final double CENA_NORMALNEGO = 3.0;
    private static final double CENA_ULGOWEGO = 1.5;
    private static ArrayList<Transakcja> listaTransakcji = new ArrayList<>();
    private String identyfikator;
    private String adres;

    public Biletomat(String identyfikator, String adres) {
        this.identyfikator = identyfikator;
        this.adres = adres;
    }

    public static void main(String[] args) {
        Biletomat biletomat1 = new Biletomat("B01", "ul. Krakowska 1");
        Biletomat biletomat2 = new Biletomat("B02", "ul. Warszawska 2");

        System.out.println("Witaj w biletomacie!");

        while (true) {
            System.out.println("Wybierz biletomat:");
            System.out.println("1. " + biletomat1.adres);
            System.out.println("2. " + biletomat2.adres);
            System.out.println("3. Wyjście");

            Scanner scanner = new Scanner(System.in);
            int wyborBiletomatu = scanner.nextInt();

            if (wyborBiletomatu == 1) {
                obsluzBiletomat(biletomat1);
            } else if (wyborBiletomatu == 2) {
                obsluzBiletomat(biletomat2);
            } else if (wyborBiletomatu == 3) {
                System.out.println("Do widzenia!");
                return;
            } else {
                System.out.println("Nieprawidłowy wybór biletomatu!");
            }
        }
    }

    private static void obsluzBiletomat(Biletomat biletomat) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz rodzaj biletu:");
            System.out.println("1. Bilet normalny (" + CENA_NORMALNEGO + " zł)");
            System.out.println("2. Bilet ulgowy (" + CENA_ULGOWEGO + " zł)");
            System.out.println("3. Wyświetl transakcje");
            System.out.println("4. Wyświetl transakcje dla Serwisu");
            System.out.println("5. Wyjście");

            int wyborBiletu = scanner.nextInt();

            if (wyborBiletu == 1) {
                System.out.println("Wybrano bilet normalny.");
                System.out.println("Wpłać " + CENA_NORMALNEGO + " zł");

                double wplaconaKwota = scanner.nextDouble();

                if (wplaconaKwota < CENA_NORMALNEGO) {
                    System.out.println("Niewystarczająca kwota!");
                    continue;
                }

                Transakcja transakcja = new Transakcja(new BiletNormalny(), CENA_NORMALNEGO);
                biletomat.dodajTransakcje(transakcja);
                biletomat.drukujBilet(transakcja.getBilet());
                biletomat.zwrocReszte(wplaconaKwota - CENA_NORMALNEGO);
            } else if (wyborBiletu == 2) {
                System.out.println("Wybrano bilet ulgowy.");
                System.out.println("Wpłać " + CENA_ULGOWEGO + " zł");
                double wplaconaKwota = scanner.nextDouble();

                if (wplaconaKwota < CENA_ULGOWEGO) {
                    System.out.println("Niewystarczająca kwota!");
                    continue;
                }

                Transakcja transakcja = new Transakcja(new BiletUlgowy(), CENA_ULGOWEGO);
                biletomat.dodajTransakcje(transakcja);
                biletomat.drukujBilet(transakcja.getBilet());
                biletomat.zwrocReszte(wplaconaKwota - CENA_ULGOWEGO);
            } else if (wyborBiletu == 3) {
                biletomat.wyswietlTransakcje();
            } else if (wyborBiletu == 4) {
                if (biletomat instanceof Serwis) {
                    ((Serwis) biletomat).wypiszLog();
                } else {
                    System.out.println("Nie jesteś uprawniony do wyświetlenia logów serwisowych.");
                }
            } else if (wyborBiletu == 5) {
                System.out.println("Powrót do wyboru biletomatu.");
                return;
            } else {
                System.out.println("Nieprawidłowy wybór biletu!");
            }
        }
    }

    private void dodajTransakcje(Transakcja transakcja) {
        listaTransakcji.add(transakcja);
    }

    private void drukujBilet(Bilet bilet) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String data = sdf.format(new Date());

        System.out.println("Biletomat: " + identyfikator);
        System.out.println("Data: " + data);
        System.out.println("Bilet: " + bilet);
    }

    private void zwrocReszte(double reszta) {
        if (reszta > 0) {
            System.out.println("Twoja reszta: " + reszta + " zł");
        }
    }

    private void wyswietlTransakcje() {
        if (listaTransakcji.isEmpty()) {
            System.out.println("Brak transakcji.");
        } else {
            for (Transakcja transakcja : listaTransakcji) {
                System.out.println(transakcja);
            }
        }
    }
}

class Transakcja {
    private Bilet bilet;
    private double cena;
    private Date data;

    public Transakcja(Bilet bilet, double cena) {
        this.bilet = bilet;
        this.cena = cena;
        this.data = new Date();
    }

    public Bilet getBilet() {
        return bilet;
    }

    public double getCena() {
        return cena;
    }

    public Date getData() {
        return data;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Bilet: " + bilet.toString() + ", cena: " + cena + ", data: " + dateFormat.format(data);
    }
}
class Biletomat2 implements Serwis {
    // reszta kodu
    private ArrayList<Transakcja> listaTransakcji = new ArrayList<>();

// reszta kodu

    public void dodajTransakcje(Transakcja transakcja) {
        listaTransakcji.add(transakcja);
    }

    public void drukujBilet(Bilet bilet) {
        System.out.println("Drukowanie biletu...");
        System.out.println(bilet.toString());
    }

    public void zwrocReszte(double reszta) {
        System.out.println("Zwrot reszty: " + reszta + " zł");
    }

    public void wyswietlTransakcje() {
        if (listaTransakcji.isEmpty()) {
            System.out.println("Brak transakcji do wyświetlenia.");
        } else {
            System.out.println("Lista transakcji:");
            for (Transakcja transakcja : listaTransakcji) {
                System.out.println(transakcja.toString());
            }
        }
    }

    public void napraw() {
        System.out.println("Biletomat został naprawiony.");
    }

    public void wypiszLog() {
        System.out.println("Logi serwisowe:");
        if (listaTransakcji.isEmpty()) {
            System.out.println("Brak transakcji.");
        } else {
            for (Transakcja transakcja : listaTransakcji) {
                System.out.println(transakcja.toString());
            }
        }
    }
}



