package kaunas.jug.meetup2.lambda;

/**
 * <p>Demonstrates functional interface.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
@FunctionalInterface
public interface Builder {
    public abstract void build();
    public abstract String toString();
    public default boolean isTrusted() { return false; }
    public static Builder empty() { return () -> {}; }
}