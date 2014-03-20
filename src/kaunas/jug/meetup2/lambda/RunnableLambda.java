package kaunas.jug.meetup2.lambda;

/**
 * <p>Class demonstrates using Lambdas for Runnable.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class RunnableLambda {

    public static void main(String[] args) {

        // Anonymous Class implementation
        Runnable runAnonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Anonymous Class Thread!");
            }
        };

        // Lambda implementation
        Runnable runLambda = () -> System.out.println("Hello from Lambda Thread!"); ;
        //runLambda();

        new Thread(runAnonymous).start();
        new Thread(runLambda).start();

    }
}
