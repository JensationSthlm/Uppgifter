public class Uppgifter implements Comparable<Uppgifter> {

    private String name;
    // prioritering måste vara heltal mellan 0-5.
    private int prioritering;
    // tidsåtgång i hela minuter.
    private int tidsÅtgång;


    public Uppgifter(String name, int prioritering){
        this.name=name;
        this.prioritering=prioritering;
    }

    // Overloadad konstruktor för de gånger vi vet tidsåtgången.
    public Uppgifter(String name, int prioritering, int tidsÅtgång){
        this.name=name;
        this.prioritering=prioritering;
        this.tidsÅtgång=tidsÅtgång;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrioritering(int prio){
        if (prio < 0 || 5 < prio){
            System.out.println("Prioritering måste vara mellan 0-5.");
        } else{
            this.prioritering=prio;
        }
    }

    public int getPrioritering() {
        return this.prioritering;
    }

    public void setTidsÅtgång(int tidsÅtgång) {
        this.tidsÅtgång = tidsÅtgång;
    }

    public int getTidsÅtgång() {
        return this.tidsÅtgång;
    }

    public int compareTo(Uppgifter uppgift){
        return uppgift.prioritering-this.prioritering;
    }

    @Override
    public String toString() {
        return this.name+". Prioritering: "+this.prioritering;
    }
}
