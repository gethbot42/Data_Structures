package sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * A simple example to see how the mathematical concepts of set union, difference, and intersection can
 * be implemented in java.
 * @author Todd A. Qualiano
 */
public class SetExample {

    public static <E> Set<E> setUnion(Set<E> A, Set<E> B){
        Set<E> result = new TreeSet<>();
        result.addAll(A);
        result.addAll(B);
        return result;
    }
    
    public static <E> Set<E> setIntersection(Set<E> A, Set<E> B){
        Set<E> result = new TreeSet<>();
        result.addAll(A);
        result.retainAll(B);
        return result;
    }
	
	public static <E> Set<E> Difference(Set A, Set B){
        Set<E> result = new TreeSet<>();
        result.addAll(A);
        result.removeAll(B);
        return result;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] array
                = {"bill",
                    "xavior",
                    "cat",
                    "mouse",
                    "horse",
                    "bill",
                    "cat",};
        
        Set<String> sample1 = new HashSet<>();
        Set<String> sample2 = new TreeSet<>();
        for(int i = 0; i < array.length; i++){
            System.out.println("***");
            System.out.println();
            System.out.println(sample1.add(array[i]));
            System.out.println(sample2.add(array[i]));
        }
        
        System.out.println("***");
        System.out.println(sample1);
        System.out.println(sample2);
        
        
    }
}


