
import java.util.EmptyStackException;

/**
 * FIS is a Finite Integer Stack.
 *
 * <p>
 * This class models a stack that holds integers. It uses an array to store the
 * integers. It does not resize the array. The capacity of the array is fixed at
 * the time of its creation.
 * </p>
 * 
 * 
 *  <img src="../../../build/classes/resources/fis.png" alt="UML class diagram">
 * 
 * <p>
 * Stacks rank among the most important data structures.
 * See, for example, <a href="http://mathworld.wolfram.com/Stack.html">this
 * brief note on MathWorld</a>.
 * </p>
 * 
 * @author Leon Tabak
 * @version 24 March 2015
 */
public class FIS {

    /**
     * Store the contents of the stack in this array.
     */
    private final int[] data;
    /**
     * Store the number of integers on the stack and the index in the array at
     * which the next integer that is pushed onto the stack should be stored
     * here.
     */
    private int size;

    /**
     * Create a stack.
     *
     * @param capacity is the limit on how many integers can be stored in this
     * stack.
     */
    public FIS(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    } // FIS( int )

    /**
     * Check to see if there are any integers on the stack.
     *
     * @return true if there are not integers stored on the stack and false
     * otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    } // isEmpty()

    /**
     * Check to see if there is room to store another integer.
     *
     * @return true if there is no more room for another integer and false
     * otherwise.
     */
    public boolean isFull() {
        return this.size == this.data.length;
    } // isFull()

    /**
     * Place another integer on the top of the stack.
     *
     * @param value is the integer to be pushed onto the stack.
     */
    public void push(int value) {
        if (this.isFull()) {
            throw new StackFullException();
        } // if
        else {
            this.data[this.size] = value;
            this.size++;
        } // else
    } // push( int )

    /**
     * Remove the integer that is at the top of the stack and return its value
     * to the caller.
     *
     * @return the value of the integer at the top of the stack.
     */
    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } // if
        else {
            this.size--;
            return this.data[this.size];
        } // else
    } // pop()

    /**
     * Examine the integer that is at the top of the stack without removing it
     * from the stack.
     *
     * @return the value of the integer at the top of the stack.
     */
    public int top() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } // if
        else {
            return this.data[this.size - 1];
        } // else
    } // top()
} // FIS
