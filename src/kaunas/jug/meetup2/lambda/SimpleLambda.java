package kaunas.jug.meetup2.lambda;

/**
 * <p>Class demonstrates difference between Lambda and Anonymous class syntax and verbosity.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class SimpleLambda {
    public static void main(String[] args) {
        Artist artist = new SimpleLambda().new Artist();

        artist.perform(
                new Action() {
                    @Override
                    public void process() {
                        System.out.println("Hello, Anonymous Class");
                    }
                }
        );

        artist.perform(
                () -> System.out.println("Hello, Lambda")
        );
    }

    // Functional interface
    @FunctionalInterface
    interface Action {
        void process();
    }

    // Class which uses Action interface as method's parameter
    class Artist {
        public void perform(Action action) {
            action.process();
        }
    }
}
