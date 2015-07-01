/**
 * The faculty class
 */
package university;

import static university.Class.MAX_CLASS;

/**
 *
 * @author
 */
public class Faculty extends Person implements Class{
    String[] courseList;
    String department;
    
    Faculty(String name, int age, String department){
	super(name, age);
	this.department = department;
        this.courseList =  new String [MAX_CLASS];
    }
    
    Faculty(String name, int age, double money, String department){
	super(name, age, money);
	this.department = department;
        this.courseList =  new String [MAX_CLASS];
    }
    
    public class Lecturer extends Faculty {
        int year;
        
        Lecturer(String name, int age, double money, String department, int year){
            super(name, age, money, department);
            this.year = year; //years of teaching class
        }
    
    }
    
    public void buy_credit(){        
        this.money += 50.00;
        System.out.println("Welcome... Now you have $" + this.money+ "!\n");

    } 
    
}
