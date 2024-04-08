package picnic;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/input.txt");
        SortingMachine sm = new SortingMachine(inputFile);
    }
}
