package kaunas.jug.meetup2.lambda;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;

/**
 * <p>Couple trivial usages of "standard" functional interfaces.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class FunctionLambda {

    public static final Predicate<Character> IS_VOWEL = c -> "AEIOUaeiou".indexOf(c) != -1;

    public static void main(String[] args) {

        System.out.println(IS_VOWEL.test('a'));
        System.out.println(IS_VOWEL.test('r'));

        DoubleUnaryOperator square = (d) -> d * d;
        DoubleUnaryOperator twice = d -> 2 * d;

        System.out.println(square.applyAsDouble(5));
        System.out.println(twice.applyAsDouble(Math.PI));

        double v = square.andThen(twice).applyAsDouble(3);
        System.out.println(v);

        double x = square.compose(square).andThen(square).applyAsDouble(2);
        System.out.println(x);
    }
}
