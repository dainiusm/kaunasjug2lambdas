package kaunas.jug.meetup2.lambda;

import java.util.*;

/**
 * <p>Class demonstrates how to use Lambdas to sort collections.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class ComparatorLambda {
    public static void main(String[] args) {

        List<String> vegetables;

        // Sorting using Anonymous class
        vegetables = Arrays.asList("Carrot", "Watercress", "Dill", "Pea");
        Collections.sort(vegetables, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return -s1.compareTo(s2);
            }
        });
        System.out.println("1. "+vegetables);

        // Sorting using Lambda
        vegetables = Arrays.asList("Carrot", "Watercress", "Dill", "Pea");
        Collections.sort(vegetables, (String s1, String s2) -> { return -s1.compareTo(s2); });
        System.out.println("2. "+vegetables);

        // Sorting using Lambda with implicit parameters types and body as expression
        vegetables = Arrays.asList("Carrot", "Watercress", "Dill", "Pea");
        vegetables.sort((s1, s2) -> -s1.compareTo(s2));
        System.out.println("3. "+vegetables);
    }
}
