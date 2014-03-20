package kaunas.jug.meetup2.lambda;

/**
 * <p>Demonstrates `effectively final` references with Lambdas and Anonymous Classes.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class FinalLambda {
    public static final String NL = System.getProperty("line.separator");

    public static void main(String[] args) {
        new FinalLambda().test();
    }

    public void test() {

        // Reference is `effectively final`
        String firstMessage = "First Message";
        Runnable first = () -> System.out.println("1. " + firstMessage);
        first.run();


        // Value is changed (uncomment to see impact)
        int i = 10;
        Runnable second = () -> System.out.println("2. " + i);
//        i++; // Uncomment and compilation will fail
        second.run();


        // Object value is changed but not a reference
        long count[] = new long[]{0};
        Runnable third = () -> {
            count[0]++;
            System.out.println("3. " + count[0]);
        };
        third.run();


        // Two executions of Lambda and object's internal state change between them
        StringBuilder builder = new StringBuilder();
        Runnable fourth = () -> System.out.println("4. " + builder);
        fourth.run();
        builder.append("First message").append(NL);
        builder.append("Second message");
        fourth.run();


        // Anonymous class accepts effectively final references as well
        @SuppressWarnings("Convert2Lambda")
        Runnable fifth = new Runnable() {
            @Override
            public void run() {
                System.out.println("* " + firstMessage);
                System.out.println("* " + i);
                count[0]++;
                System.out.println("*" + count[0]);
            }
        };
        fifth.run();
    }
}
