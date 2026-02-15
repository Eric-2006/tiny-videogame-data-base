import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class VideoGameInfoReader {

    public static VideoGameInfo readVideoGameFile (String fileName) throws IOException {
        String title;
        String series;
        String publisher;
        short year;
        int sales;

        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line;
        boolean isDigit = true;

        line = input.readLine();
        if (line.isEmpty()) {
            throw new IOException("Error: Títol buit al fitxer " + fileName);
        }
        title = line;

        line = input.readLine();
        if (line.isBlank()) {
            line = "";
        }
        series = line;

        line = input.readLine();
        if (line.isBlank()) {
            System.err.println("Advertència: Editor buit al fitxer " + fileName);
            line = "";
        }
        publisher = line;

        line = input.readLine();
        if (line.isBlank()) {
            System.err.println("Advertència: Any biut al fitxer " + fileName);
            line = "-1";
        }
        else {
            for (int i = 0; i < line.length() && isDigit; i++) {
                int digit = (line.charAt(i) - '0');
                if (digit < 0 || digit > 9) {
                    System.err.println("Advertència: L'any no és un nombre en el fitxer " + fileName);
                    line = "-1";
                    isDigit = false;
                }
            }
        }
        year = Short.parseShort(line);

        isDigit = true;
        line = input.readLine();
        if (line.isBlank()) {
            System.err.println("Advertència: Vendes buides al fitxer " + fileName);
            line = "-1";
        }
        else {
            for (int i = 0; i < line.length() && isDigit; i++) {
                int digit = line.charAt(i) - '0';
                if (digit < 0 || digit > 9) {
                    System.err.println("Advertència: El número de vendes no és un nombre en el fitxer " + fileName);
                    line = "-1";
                    isDigit = false;
                }
            }
        }
        sales = Integer.parseInt(line);

        input.close();
        return new VideoGameInfo(title, series, publisher, year, sales);
    }

}