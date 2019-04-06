import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteToFile {
private String path; // adressen till filen.
private boolean appendToFile = false; // ska den srkiva över det som finns eller lägga till i slutet.

// om man vill skriva över och göra ny fil.
    public WriteToFile(String filePath){
    this.path=filePath;
    }

// Om man vill lägga till i listan.
    public WriteToFile(String filePath, boolean appendValue){
        this.path=filePath;
        this.appendToFile=appendValue;
    }

    public void writeToFile( String textLine ) throws IOException {
        FileWriter write = new FileWriter( path , appendToFile);
        PrintWriter print_line = new PrintWriter( write );
        print_line.printf( "%s" + "%n" , textLine);
        print_line.close();

    }


}

