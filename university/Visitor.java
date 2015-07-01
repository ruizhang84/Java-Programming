/*
 * Visitor class extends from Person class.
 */
package university;
import static university.Class.MAX_CLASS;
        
/**
 *
 * @author author
 */
public class Visitor extends Person implements Class{
    String[] courseList;
    String city;
    
    Visitor(String name, int age, String city){
	super(name, age);
	this.city = city;
        this.courseList =  new String [MAX_CLASS];
    }
    
    Visitor(String name, int age, double money, String city){
	super(name, age, money);
	this.city = city;
        this.courseList =  new String [MAX_CLASS];
    }
    
    public void setPlace(String city){
        this.city = city;   
    }
    
    public void setCourseList(String[] courseList){
        System.arraycopy(courseList, 0, this.courseList, 0, courseList.length);   
    }
   
    
    
    public void add_class(String course) {
     /**
     * @param String course
     * @return String[] courseList
     */
        if (this.courseList[MAX_CLASS-1] != null) {
            System.out.println("Maximum allowed classes exceeded!"
                    + "Could not add the class!");
            return;
        }
        
        for(int i = 0; i < this.courseList.length; i++) {
            if(course.equals(this.courseList[i])) {
                System.out.println("You already add this class!");
                return;
            }
        }
        
        for(int i = 0; i < courseList.length; i++) {
            if(this.courseList[i] == null) {
                this.courseList[i] = course;
                break;
            }
        }       
        System.out.println ("Add a new course: "+ course);
        return;
    }
    
    public void drop_class(String course){
        if (this.courseList[0] == null) {
            System.out.println("No classes to drop!");
            return;
        }
        
        /*search the last class in the course list*/
        int i = 0;  
        for( i = 0; i < this.courseList.length; i++) {
            if(this.courseList[i] == null) {
                break;
            }
        }
        /* swap the dropped class with the last class, drop*/
        for( int j = 0; j < this.courseList.length; j++) {
            if(course.equals(this.courseList[j])) {
                this.courseList[j] = this.courseList[i-1];
                this.courseList[i-1] = null;
                break;
            }
        }
        System.out.println ("Success drop a course: "+ course);   
    }
    
    @Override
    public void buy_credit(){
        int num = 0;  //search the number of courses
        for( num = 0; num < this.courseList.length; num++) {
            if(this.courseList[num] == null) {
                break;
            }
        }
        
        double temp = this.money - 500.00 * num;
        if (temp > 0){
            this.money = temp;
            System.out.println("Welcome! Now you have $" + this.money+ "left!\n"); 
        }else{
            System.out.println("You don't have enough money, "
                    + "try to drop some courses\n");
        }
        
    }

}
