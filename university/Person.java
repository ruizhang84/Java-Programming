/*
 * Person class, base classs
 */
package university;

/**
 *
 * @author author
 */
public class Person {
    protected String name;
    protected int age;
    protected double money;
    
    
    Person(){
       	this.name = "";
	this.age = 1;
        this.money = 0.00; 
    }

    Person(String name, int age){
	this.name = name;
	this.age = age;
        this.money = 0.00;
    }
    
    Person(String name, int age, double money){
	this.name = name;
	this.age = age;
        this.money = money;
    }
    
    public String getName(){
        return this.name;      
    }
    public int getAge(){
        return this.age;      
    }      
        
    public double getMoney(){
        return this.money;      
    } 
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setMoney(double money){
        this.money = money;
    }
    
}
