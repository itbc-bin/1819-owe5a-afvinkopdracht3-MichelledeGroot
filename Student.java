public class Student {

    private String naam;  //instance variabele
    private int studentnr;
    private int leeftijd; //instance variabele
    private static int minLeeftijd = 18;  //class variabele

    public Student(String naam){  //Constructor een
        this.naam = naam;
    }

    public Student(String naam, int leeftijd){// Overloaded constructor twee
        this.naam = naam;
        setLeeftijd(leeftijd);
    }
    public Student(String naam, int leeftijd, int studentnr){// Overloaded constructor twee
        this.naam = naam;
        setLeeftijd(leeftijd);
        this.studentnr = studentnr;
    }

    public void setLeeftijd(int getal) {
        if (getal < getMinLeeftijd()||getal>80) {
            System.out.println("De leeftijd van "+getal+" is geen toegestane leeftijd!");
        } else {
            leeftijd = getal;
        }
    }

    public void info(){
        System.out.println("\n");
        System.out.println("Dit is student "+getNaam());
        if(leeftijd>0) {
            System.out.println("Met een leeftijd van "+leeftijd);
        }
        if(studentnr>0) {
            System.out.println("Studentnummer is " + studentnr);
        }
    }

    public static int getMinLeeftijd() {
        return minLeeftijd;
    }

    public static void setMinLeeftijd(int aMinLeeftijd) {
        minLeeftijd = aMinLeeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}