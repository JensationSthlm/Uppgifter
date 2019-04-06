import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Interface {
    private ListaUppgifter listaUppgifter;
    private ListaUppgifter listaUtfordaUppgifter;
    Scanner reader;
    private WriteToFile skrivare;// lägger till efter sista raden.
    private WriteToFile skrivareNy; // tar bort det som redan finns och skriver på nytt


    public Interface(){
        this.listaUppgifter= new ListaUppgifter();
        this.listaUtfordaUppgifter= new ListaUppgifter();
        this.reader = new Scanner(System.in);
        this.skrivare = new WriteToFile("text", true);
    }

    public void start() {

        listaUppgifter.addUppgift(new Uppgifter("Städa", 3));
        listaUppgifter.addUppgift(new Uppgifter("Skura", 2));
        listaUppgifter.addUppgift(new Uppgifter("Spela", 5));
        listaUtfordaUppgifter.addUppgift(new Uppgifter("Leka", 5));

        while (true) {

            System.out.println("Vad vill du göra?" +
                    " Du kan:\n" +
                    "\n" +
                    "1: Skriv ut uppgifter efter prioritering\n" +
                    "2: Lägg till uppgift\n" +
                    "3: Ta bort uppgift\n" +
                    "4: Se utförda uppgifter.\n" +
                    "5: Skriv ut listan i fil.\n" +
                    "6: Avsluta.");

            System.out.println();

            String command = reader.next();

            if (command.equals("1")) {
                // Skriver ut datumet listan genereras
                System.out.println("Uppgifter den: "+LocalDate.now());
                //sorterar listan efter prioritering
                this.listaUppgifter.sorteraListaPrioritering();
                for (Uppgifter x : listaUppgifter.getListaUppgifter()) {
                    System.out.println(x);
                }
                System.out.println();
            } else if (command.equals("2")){
                    addUppgift();

            } else if (command.equals("3")){
                taBortUppgift();

            } else if (command.equals("4")){
                for (Uppgifter x : this.listaUtfordaUppgifter.getListaUppgifter()) {
                    System.out.println(x);
                }

            } else if (command.equals("5")){
                for (Uppgifter x : listaUppgifter.getListaUppgifter()) {
                   // Nedan skriver ut listan till filen Text
                    try {
                        skrivare.writeToFile(x.toString());
                    }
                    catch (IOException e){
                        System.out.println("Fungerade inte");
                    }
                }

            } else if (command.equals("6")){
                    break;
                }
            }
        }

// frågar användaren efter namn och prioritering, sen lägger till det i lisan.
    public void addUppgift(){
        System.out.println("Vad är det för uppgift?");
        String name  = reader.next();
        System.out.println("Vad är det för prioritering?");
        int prioritering = Integer.parseInt(reader.next());
        this.listaUppgifter.addUppgift(new Uppgifter(name,prioritering));
        System.out.println();
    }

    // frågar användaren efter uppgift och tar sedan bort den ur listan.
    public void taBortUppgift(){
        System.out.println("Vad är det för uppgift som ska tas bort?");
        String name = reader.next();

            // Det här är inte smartaste lösningen eftersom den kör igenom listan flera gånger. Därför har jag lagt
            // till break som ska bryta loopen.
         for (int i = 0; i<listaUppgifter.getListaUppgifter().size(); i++){
             if (listaUppgifter.getListaUppgifter().get(i).getName().equals(name)){
                 // hämtar uppgiften som ska tas bort och lägger till den i listan för borttagna.
                 listaUtfordaUppgifter.getListaUppgifter().add(listaUppgifter.getListaUppgifter().get(i));
                 // tar bort uppgiften ur huvudlistan.
                 listaUppgifter.getListaUppgifter().remove(i);
                 System.out.println(name +" har tagits bort.");
                 break;
             } else {
                 System.out.println(name+ " fanns inte i listan.");
                 break;
             }
         }
    }
}
