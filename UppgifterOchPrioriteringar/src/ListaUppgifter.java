import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaUppgifter {
   private List<Uppgifter> listaUppgifter;


   public ListaUppgifter(){
       this.listaUppgifter=new ArrayList<>();
   }

   //lägger till ett objects uppgift i listan.
   public void addUppgift(Uppgifter uppgift){
       this.listaUppgifter.add(uppgift);
   }

   // retunerarn listan med alla uppgifter.
    public List<Uppgifter> getListaUppgifter() {
        return listaUppgifter;
    }

    //sorterar listan efter uppgifternas prioritering
    public void sorteraListaPrioritering(){
        Collections.sort(this.listaUppgifter);
    }


}
