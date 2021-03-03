package kemiaielemek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class KemiaiElemek {

    public static void main(String[] args) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get("felfedezesek.csv"));
        ArrayList<Felfedezes> Felfedezesek = new ArrayList<>();

        for (int i = 1; i < sorok.size(); i++) {
            Felfedezesek.add(new Felfedezes(sorok.get(i)));
        }

        /*3.feladat*/
        System.out.println("3.feladat");
        int db = 0;
        for (int i = 0; i < Felfedezesek.size(); i++) {
            db++;
        }
        System.out.println("Elemek száma: " + db);
        /*4.feladat*/
        System.out.println("4.feladat:");
        int okoriFelfedezesek = 0;
        for (Felfedezes felfedezes : Felfedezesek) {
            if (felfedezes.getEv().equals("Ókor")) {
                okoriFelfedezesek++;
            }
        }
        /*5.Feladat*/
        Scanner sc = new Scanner(System.in);
        boolean vegyjelE = false;
        String ertek = "";
        while (!vegyjelE) {
            System.out.print("5. Feladat: Kérek egy vegyjelet: ");
            ertek = sc.nextLine();
            if (ertek.length() <= 2) {
                for (int i = 0; i < ertek.length(); i++) {
                    char c = ertek.charAt(i);
                    if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                        vegyjelE = false;
                    } else {
                        vegyjelE = true;
                    }
                }

            }
        }
        //System.out.println(ertek);
        /*6.Feladat*/
        System.out.println("6. Feladat: Keresés");
        int i = 0;
        while (i < Felfedezesek.size() - 1 && !(Felfedezesek.get(i).getVegyjel().toLowerCase().equals(ertek.toLowerCase()))) {
            i++;
        }
        if (i >= Felfedezesek.size() - 1) {
            System.out.println("Nincs ilyen elem az adatforrásban!");
        } else {
            Felfedezes sor = Felfedezesek.get(i);
            System.out.println("\tAz elem vegyjele: " + sor.getVegyjel()
                    + "\n\tAz elem neve: " + sor.getElem()
                    + "\n\tRendszáma: " + sor.getRendszam()
                    + "\n\tFelfedezés éve: " + sor.getEv()
                    + "\n\tFelfedező: " + sor.getFelfedezo());
        }

        System.out.println("Felfedezések számaz az Ókorban: " + okoriFelfedezesek);
        /*7.feladat*/
        System.out.println("7.feladat:");
        int kulombseg = 0;
        for (i = 0; i < Felfedezesek.size() - 1; i++) {
            if (!Felfedezesek.get(i).getEv().equals("Ókor")) {
                if (kulombseg < Integer.parseInt(Felfedezesek.get(i + 1).getEv()) - Integer.parseInt(Felfedezesek.get(i).getEv())) {
                    kulombseg = Integer.parseInt(Felfedezesek.get(i + 1).getEv()) - Integer.parseInt(Felfedezesek.get(i).getEv());
                }
            }
        }
        System.out.println(kulombseg + " volt a legtöbb év között");
        //System.out.println(felfedezes);
        /*8.feladat*/
        System.out.println("8.feladat");
        HashMap<String, Integer> elemekFelf = new HashMap<>();

        for (Felfedezes felf : Felfedezesek) {
            if (elemekFelf.containsKey(felf.getEv())) {
                elemekFelf.put(felf.getEv(), elemekFelf.get(felf.getEv()) + 1);
            } else {
                elemekFelf.put(felf.getEv(), 1);
            }
        }

        for (Map.Entry<String, Integer> elem : elemekFelf.entrySet()) {
            String key = elem.getKey();
            Integer value = elem.getValue();
            if (value > 3 && szamE(key)) {
                System.out.println(key + " : " + value);
            }

        }
    }

    /*8.feladathoz tartozik*/
    public static boolean szamE(String kulcs) {
        try {
            Integer.parseInt(kulcs);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
