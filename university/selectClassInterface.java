/*
 * The interface, add, drop, and buy credit for class.
 */
package university;

/**
 *
 * @author author
 */
public interface selectClassInterface {
    void add_class(String course);
    void drop_class(String course);
    void buy_credit(); //student and visitor has different price
}
