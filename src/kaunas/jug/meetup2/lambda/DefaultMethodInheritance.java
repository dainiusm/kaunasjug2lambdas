package kaunas.jug.meetup2.lambda;

/**
 * <p>Demonstrates default method inheritance.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class DefaultMethodInheritance {

    public static void main(String[] args) {
        new DefaultMethodInheritance().test();
    }

    void test() {
        new X().m();
        new Y().m();
        new Z().m();
    }

    class X implements A, B, C {}

    class Y extends X implements A, B/*, D*/ {} // If D Uncommented, it fails

    class Z extends X implements A, B, D {
        @Override
        public void m() {
            D.super.m();
        }
    }

    interface A {
        default void m() { System.out.println("A"); }
    }

    interface B extends A {}

    interface C extends B {
        default void m() { System.out.println("C"); }
    }

    interface D {
        default void m() { System.out.println("D"); }
    }
}
