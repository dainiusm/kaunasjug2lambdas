package kaunas.jug.meetup2.lambda;

/**
 * <p>Class demonstrates that Lambda's `this` equals to outer context `this`.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class ThisLambda {
    public static void main(String[] args) {
        new ThisLambda().testThis();
    }

    public void testThis() {

        // print 'this' reference
        System.out.println("This:       " + this);

        // print Anonymous 'this' reference
        perform(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous:  " + this);
                System.out.println("This.Outer: " + ThisLambda.this);
            }
        });

        // Print Lambda 'this' reference
        perform(() -> System.out.println("Lambda:     " + this));

    }

    public void perform(Runnable runnable) {
        runnable.run();
    }
}
