/*
 * The main class.
 */
package university;
/**
 *
 * @author author
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        selectClassInterface student1 = new Student("Meimei Han", 18, 1000.00, "Chemistry");
        student1.add_class("Organic Synthesis");
        student1.add_class("Special Topic in Biochemistry");
        student1.add_class("Advanced Spectrometry");
        student1.buy_credit();
               
        selectClassInterface visitor1 = new Visitor("Li Hua", 28, 10.00, "ShenZhen");
        visitor1.add_class("MBA");
        visitor1.buy_credit();
        
        Faculty faculty1= new Faculty("Lucy", 28, 10.00, "Chemistry");
        selectClassInterface Lecture1 = faculty1.new Lecturer ("Lucy", 28, 10.00, "Chemistry", 10);
        Lecture1.add_class("Introduction to Education");
        Lecture1.buy_credit();
    }
    
}
