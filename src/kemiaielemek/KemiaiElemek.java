package kemiaielemek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class KemiaiElemek {

    public static void main(String[] args) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get("felfedezesek.csv"));
        ArrayList<Felfedezes> Felfedezesek = new ArrayList<>();
        for (int i = 1; i < sorok.size(); i++) {
            String sor = sorok.get(i);
            Felfedezesek.add(new Felfedezes(sor));
        }
        
        
    }
    
}
