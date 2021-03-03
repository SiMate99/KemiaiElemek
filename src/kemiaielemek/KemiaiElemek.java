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
        for (String sor : sorok) {
            Felfedezesek.add(new Felfedezes(sor));
        }
    }
    
}
