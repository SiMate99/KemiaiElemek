package kemiaielemek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        for (Felfedezes felfedezes : Felfedezesek) {
            if (felfedezes.getEv().equals("Ókor")) {
                System.out.println(felfedezes);
            }
        }
        /*8.feladat*/
        System.out.println("8.feladat");
        HashMap<String,Integer> elemekFelf = new HashMap<>();
        
        for (Felfedezes felf : Felfedezesek) {
            if (elemekFelf.containsKey(felf.getEv())) {
                elemekFelf.put(felf.getEv(), elemekFelf.get(felf.getEv())+1);
            }else{elemekFelf.put(felf.getEv(),1);}
        }
        
        for (Map.Entry<String, Integer> elem : elemekFelf.entrySet()) {
            String key = elem.getKey();
            Integer value = elem.getValue();
            if (value > 3 && isString(key) ) {
                System.out.println(key +" : "+value);
            }
            
        }
        
    }

    public static boolean isString (String kulcs){
        try {
            Integer.parseInt(kulcs);
        } catch (Exception e) {
         return false;
        }
        return true;
    }
    
}
