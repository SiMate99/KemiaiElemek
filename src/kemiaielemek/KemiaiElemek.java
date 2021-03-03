package kemiaielemek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KemiaiElemek {

    public static void main(String[] args) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get("felfedezesek.csv"));
        ArrayList<Felfedezes> Felfedezesek = new ArrayList<>();
        for (int i = 1; i < sorok.size(); i++) {
            String sor = sorok.get(i);
            Felfedezesek.add(new Felfedezes(sor));
        }
        
        System.out.println("5. Feladat");
        Scanner sc = new Scanner(System.in);
        boolean vegyjelE = false;
        String ertek = "";
        while(!vegyjelE){
            System.out.print("Kérek egy vegyjelet: ");
            ertek = sc.nextLine();
            if (ertek.length() <= 2) {
                for (int i = 0; i < ertek.length(); i++) {
                    char c = ertek.charAt(i);
                    if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                        vegyjelE = false;
                    }else{
                        vegyjelE = true;
                    }
                }
                
            }
        }
        //System.out.println(ertek);
        
        System.out.println("6. Feladat: Keresés");
        int i = 0;
        while(i < Felfedezesek.size()-1 && !(Felfedezesek.get(i).getVegyjel().toLowerCase().equals(ertek.toLowerCase()))){
            i++;
        }
        if (i >= Felfedezesek.size()-1) {
            System.out.println("Nincs ilyen elem az adatforrásban!");
        }else{
            System.out.println("\tAz elem vegyjele: " + Felfedezesek.get(i).getVegyjel() +
                        "\n\tAz elem neve: " + Felfedezesek.get(i).getElem() +
                        "\n\tRendszáma: " + Felfedezesek.get(i).getRendszam() +
                        "\n\tFelfedezés éve: " + Felfedezesek.get(i).getEv() +
                        "\n\tFelfedező: " + Felfedezesek.get(i).getFelfedezo());
        }
        

    }
    
}
