import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
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
                ArrayList<Product> productList = new ArrayList<>();
                while (reader.ready()) {
                    record = reader.readLine();
                    line++;
                    String[] recordArray = record.split(",");
                    Product tempProduct = new Product(recordArray[1], recordArray[2], recordArray[0], Double.parseDouble(recordArray[3]));
                    productList.add(tempProduct);
                }
                reader.close();
                System.out.printf("\n%-10s %-11s %-24s %s\n", "ID", "Name", "Description","Cost");
                System.out.println("======================================================");

                for (int i = 0; i < productList.size(); i++) {
                    Product tempProduct = productList.get(i);
                    System.out.printf("%-10s %-10s %-25s %s\n", tempProduct.getId(), tempProduct.getName(), tempProduct.getDescription(), tempProduct.getCost());
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
