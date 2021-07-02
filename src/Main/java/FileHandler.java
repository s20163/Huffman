package Main.java;

import java.io.*;

public class FileHandler {
    public String text;

    public String readFile(String filename) throws IOException {
        FileReader fr = new FileReader("src/Main/resources/" + filename);
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        br.close();

        this.text = text;
        return text;
    }

    public void createEncodedFile(String codingTable, String msgToWrite) {
        File encodedFile = new File("src/Main/resources/encoded.txt");
        try {
            encodedFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(encodedFile);
            writer.write(codingTable + "\n" + msgToWrite);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
