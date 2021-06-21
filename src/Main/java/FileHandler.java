package Main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    public String readFile (String filename) throws IOException {
        FileReader fr = new FileReader("src/Main/resources/" + filename);
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        br.close();

        return text;
    }

    public void createEncodedFile () {}

    public void readDecodedFile () {}
}
