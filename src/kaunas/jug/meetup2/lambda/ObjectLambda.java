package kaunas.jug.meetup2.lambda;

/**
 * <p>Class demonstrates that Lambda cannot be assigned to Object type reference
 * (w/o small help).</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class ObjectLambda {

    public static void main(String[] args) {
        // Won't compile
        //  Object lambda = () -> System.out.println("Hello");
        Object lambda = (Runnable) () -> System.out.println("Hello, Object!");
        Runnable runnable = () -> System.out.println("Hello, Runnable!");

        ((Runnable) lambda).run();
        runnable.run();
    }
}
