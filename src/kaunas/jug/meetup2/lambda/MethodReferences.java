package kaunas.jug.meetup2.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <p>Examples of method references</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class MethodReferences {

    public static final Comparator<String> VEGETABLE_COMPARATOR = (lv, rv) -> lv.compareTo(rv);

    public static int compareTwoVegetablesInReverse(String s1, String s2) {
        return s2.compareTo(s1);
    }

    public static void main(String[] args) {
        new MethodReferences().test();
    }

    public void test() {
        List<String> vegetables;

        System.out.println("1. -------------------------------");
        // Sorting using reference to Lambda
        vegetables = Arrays.asList("Carrot", "Watercress", "Dill", "Pea");
        // >>>>>
        vegetables.forEach(System.out::print); System.out.println();
        vegetables.forEach((v) -> System.out.print(v)); System.out.println();

        Collections.sort(vegetables, MethodReferences.VEGETABLE_COMPARATOR.reversed());
        System.out.println(vegetables);

        System.out.println("2. -------------------------------");
        // Reference to method
        vegetables = Arrays.asList("Watercress", "Carrot", "Dill", "Pea");
        // >>>>>
        vegetables.sort(MethodReferences::compareTwoVegetablesInReverse);
        System.out.println(vegetables);

        System.out.println("3. -------------------------------");
        // Put method reference to variable
        Comparator<String> cf = MethodReferences::compareTwoVegetablesInReverse;
        System.out.println(cf);
        vegetables = Arrays.asList("Watercress", "Carrot", "Dill", "Pea");
        // >>>>>
        Collections.sort(vegetables, cf);
        System.out.println(vegetables);

        System.out.println("4. -------------------------------");
        // Construct comparator from method reference
        List<Vegetable> vegies = new ArrayList<>();
        vegies.add(new Vegetable("Pea", "green"));
        vegies.add(new Vegetable("Onion", "golden"));
        vegies.add(new Vegetable("Pepper", "red"));
        vegies.add(new Vegetable("Carrot", "orange"));
        // >>>>>
//        vegies.add(null);
//        vegies.sort(Comparator.nullsLast(comparing(Vegetable::getName)));

        vegies.sort(Comparator.comparing(Vegetable::getName));

        vegies.forEach(System.out::println);

        // Method references
        System.out.println("5. -------------------------------");
        Vegetable vegetable = new Vegetable("Eggplant", "purple");
        Supplier<String> refGetNameMethod = vegetable::getName;
        Consumer<String> refSetNameMethod = vegetable::setName;

        System.out.println(refGetNameMethod);
        System.out.println(refSetNameMethod);
        System.out.println(vegetable);
        System.out.println(refGetNameMethod.get());
        refSetNameMethod.accept("Purple Asparagus");
        System.out.println(refGetNameMethod.get());
        System.out.println(vegetable);
    }


    class Vegetable {
        private String name;
        private String color;

        Vegetable() {
        }

        Vegetable(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return name + '(' + color+ ')';
        }
    }
}
