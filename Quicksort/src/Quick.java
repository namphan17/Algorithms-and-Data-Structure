
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quick {

    private static final Random rng = new Random();

    public static List<Double> make(int n) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(rng.nextDouble());
        } // for
        return list;
    } // make( int )

    public static void print(List<Double> list) {
        for (Double x : list) {
            System.out.printf("%6.2f ", x);
        } // for
        System.out.println();
    } // print( List<Double> )

    public static void swap(List<Double> list, int i, int j) {
        Double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    } // swap( List<Double>, int, int )

    public static void partition(List<Double> list) {
        double pivot = list.get(0);
        System.out.printf("pivot = %8.2f\n", pivot);
        int i = 1;
        int j = list.size() - 1;
        while (i < j) {
            assert invariant(list, pivot, i, j) : "Invariant broken";
            
            System.out.printf("i = %2d j = %2d ", i, j);
            print(list);
        
            // do just one thing on each pass through the loop
            
            // either increase i
            // (increase the number of elements at the left end
            // of the list that we know have a value less than or
            // equal to that of the pivot)
            if (list.get(i) <= pivot) {
                System.out.printf("%8.2f < %8.2f increment i\n",
                        list.get(i), pivot);
                i++;
            } // if
            
            // or decrease j
            // (increase the number of elements at the right
            // end of the list that we know have a value greater
            // than that of the pivot)
            else if (list.get(j) > pivot) {
                System.out.printf("%8.2f >= %8.2f decrement j\n",
                        list.get(j), pivot);
                j--;
            } // if
            
            // or swap the values found at positions i and j, then
            // increase i and decrease j
            // (this happens only if the element at position i has a 
            // value greater than that of the pivot and the element at
            // position j has a value less than or equal to that of the
            // pivot)
            // (this action increases the number of elements at the left end
            // that we know are less than or equal to the pivot and
            // increases the number at the right end that we know are
            // greater than the pivot)
            else {
                System.out.println("swap elements at i and j.");
                swap(list, i, j);
                i++;
                j--;
            } // else
        } // while

        System.out.printf("i = %2d j = %2d\n", i, j);

        if (list.get(i) > pivot) {
            i--;
        } // if

        System.out.printf("index of pivot is now = %2d\n", i);
        
        swap( list, 0, i);

    } // partition( List<Double> )

    public static boolean invariant(List<Double> list,
            double pivot, int i, int j) {

        // if the partition method has been written correctly
        // then at the start of the loop the following conditions
        // will hold
        
        // all the elements whose index is less than i
        // will have a value less or equal to that of the pivot
        boolean leftTest = true;
        for (int k = 0; k < i; k++) {
            leftTest = leftTest && list.get(k) <= pivot;
        } // for

        // all the elements whose index is greater than j
        // will have a value greater than that of the pivot
        boolean rightTest = true;
        for (int k = list.size() - 1; k > j; k--) {
            rightTest = rightTest && list.get(k) > pivot;
        } // for

        // both the left test and right test will hold
        return leftTest && rightTest;
    } // invariant( List<Double>, double, int, int )

    public static void main(String[] args) {
        List<Double> data = make(8);
        print(data);
        partition(data);
        print(data);
    } // main( String [] )

} // Quick
