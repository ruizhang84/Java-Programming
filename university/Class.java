/*
 * The functions for student to add or drop courses
 */
package university;

/**
 * @author 
 */
public interface Class extends selectClassInterface{
    public static final int MAX_CLASS = 100;
    public String[] courseLists = new String [MAX_CLASS];
    
    default public void add_class(String course) {
     /**
     * @param String course
     * @return String[] courseList
     */
        if (courseLists[MAX_CLASS-1] != null) {
            System.out.println("Maximum allowed classes exceeded!"
                    + "Could not add the class!");
            return;
        }
        
        for(int i = 0; i < courseLists.length; i++) {
            if(course.equals(courseLists[i])) {
                System.out.println("You already add this class!");
                return;
            }
        }
        
        for(int i = 0; i < courseLists.length; i++) {
            if(courseLists[i] == null) {
                courseLists[i] = course;
                break;
            }
        }
        
        System.out.println ("Add a new course: "+ course);
    }
    
    default public void drop_class(String course){
        if (courseLists[0] == null) {
            System.out.println("No classes to drop!");
            return;
        }
        
        /*search the last class in the course list*/
        int i = 0;  
        for( i = 0; i < courseLists.length; i++) {
            if(courseLists[i] == null) {
                break;
            }
        }
        /* swap the dropped class with the last class, drop*/
        for( int j = 0; j < courseLists.length; j++) {
            if(course.equals(courseLists[j])) {
                courseLists[j] = courseLists[i-1];
                courseLists[i-1] = null;
                break;
            }
        }
        System.out.println ("Success drop a course: "+ course);   
    }
    
}  

