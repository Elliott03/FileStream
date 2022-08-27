import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        String record = "";
        try {


            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                System.out.printf("\n%-11s %-11s %-11s %-11s\n", "ID", "Name", "Description", "Cost");
                System.out.println("======================================================");
                int line = 0;
                while (reader.ready()) {
                    record = reader.readLine();
                    line++;
                    String[] recordArray = record.split(",");
                    for (int i = 0; i < recordArray.length; i++) {
                        System.out.printf("%-12s", recordArray[i]);
                    }
                    System.out.println("\n");
                }

                reader.close();
                System.out.println("\n\nFile Read.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
