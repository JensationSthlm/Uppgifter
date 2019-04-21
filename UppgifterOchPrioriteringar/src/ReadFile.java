import java.io.File;
import java.util.Scanner;

public class ReadFile {

    public void readFile() {
        File file = new File("C:\\Users\\Jens\\IdeaProjects\\UppgifterOchPrioriteringar\\Lista den 2019-04-09");

        Scanner reader = null;

        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return; // we exit the method
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);
        }

        reader.close();
    }
}
