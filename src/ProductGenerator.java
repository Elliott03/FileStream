import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<String> productArrayList = new ArrayList<String>();
        Scanner tempScanner = new Scanner(System.in);
        String fileName;
        boolean YN = false;

        do {

            String id = SafeInput.getNonZeroLenString(tempScanner, "ID");
            String name = SafeInput.getNonZeroLenString(tempScanner, "Name");
            String description = SafeInput.getNonZeroLenString(tempScanner, "Description");
            String cost = SafeInput.getNonZeroLenString(tempScanner, "Cost");

            Product tempProduct = new Product(name, description, id, Double.parseDouble(cost));
            productArrayList.add(tempProduct.toCSVDataRecord());
            YN = SafeInput.getYNConfirm(tempScanner, "Would you like to add another record?");

        } while(YN);

        fileName = SafeInput.getNonZeroLenString(tempScanner, "What would you like to name the file?");
        System.out.println(productArrayList);
        System.out.println(fileName);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String record : productArrayList) {
                writer.write(record, 0, record.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data File Written.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
