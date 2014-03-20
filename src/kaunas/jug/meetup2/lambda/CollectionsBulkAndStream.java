package kaunas.jug.meetup2.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * <p>Several examples of bulk and stream operations.</p>
 *
 * <p>Example prepared for Kaunas JUG meetup #2, March 19, 2014.</p>
 * <p>http://www.kaunas-jug.lt</p>
 *
 * @author Dainius Mezanskas
 */
public class CollectionsBulkAndStream {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        list.forEach((i) -> System.out.print(i+ " - "));
        System.out.println();

        list.removeIf(n -> n % 2 == 0);
        System.out.println(list);

        list.replaceAll(i -> i * 2);
        System.out.println(list);

        // Streams
        List<Integer> filteredList
                = list.stream()
                .filter(x -> x >= 10)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        Integer sum = filteredList.stream().reduce(0, (l, r) -> l + r);
        System.out.println(sum);
        System.out.println(format("sum=%d", sum));

        Integer min = filteredList.stream().reduce(Integer.MAX_VALUE, (l, r) -> l < r ? l : r);
        System.out.println(format("min=%d", min));

        Integer max = filteredList.stream().reduce(0, (l, r) -> l > r ? l : r);
        System.out.println(format("max=%d", max));

        List<Character> chars = filteredList.stream()
                .map(c -> (char) (55 + c))
                .collect(Collectors.toList());
        System.out.println(chars);
    }
}
