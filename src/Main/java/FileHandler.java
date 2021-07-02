package Main.java;

import java.io.*;

public class FileHandler {

    public String readFile (String filename) throws IOException {
        FileReader fr = new FileReader("src/Main/resources/" + filename);
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        br.close();

        return text;
    }

    public void createEncodedFile (String codeToWrite, String msgToWrite) {
        File encodedFile = new File("src/Main/resources/encoded.txt");
        try {
            encodedFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(encodedFile);
            writer.write(codeToWrite + "MSG:" + msgToWrite);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readEncodedFile () {}
}
