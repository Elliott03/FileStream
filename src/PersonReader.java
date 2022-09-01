import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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

                int line = 0;
                ArrayList<Person> personList = new ArrayList<>();
                while (reader.ready()) {
                    record = reader.readLine();
                    line++;
                    String[] recordArray = record.split(",");
                    Person tempPerson = new Person(recordArray[1], recordArray[2], recordArray[0], recordArray[3], Integer.parseInt(recordArray[4]));
                    personList.add(tempPerson);
                }
                reader.close();
                System.out.printf("\n%-8s %-11s %-11s %-10s %s\n", "ID", "First Name", "Last Name","Title", "YOB");
                System.out.println("======================================================");

                for (int i = 0; i < personList.size(); i++) {
                    Person tempPerson = personList.get(i);
                    System.out.printf("%-10s %-10s %-10s %-10s %-10d\n", tempPerson.getId(), tempPerson.getFirstName(), tempPerson.getLastName(), tempPerson.getTitle(), tempPerson.getYob());
                }
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
