import java.util.*;
import java.util.stream.Collectors;

public class PlayingWithSomeMethods {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        // Stream = data flow
        list.stream().forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        // skip() method
        list.stream()
                .skip(2)
                .forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        // limit() method
        list.stream()
                .limit(2)
                .forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        //distinct() method
        list.stream()
                .distinct() //equals and hashcode must be implemented in the target object
                .forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        //filter() method
        list.stream()
                .filter(integer -> integer % 2 == 0) //add filters, like conditional clauses
                .forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        //map() method
        list.stream()
                .map(integer -> integer * 2) //applies the condition to every element of the stream
                .forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        // using them combined

        list.stream()
                .limit(3)
                .map(integer -> integer * 2)
                .skip(2)
                .distinct()
                .forEach(integer -> System.out.println(integer));

        System.out.println("-------------------");

        //count() method
        long count = list.stream()
                .filter(integer -> integer % 2 ==0)
                .count();

        System.out.println(count);

        System.out.println("-------------------");

        //min() method
        Optional<Integer> min = list.stream()
                        .filter(integer -> integer % 2 == 0)
                        .min(Comparator.naturalOrder()); //it's needed to specify how to compare the elements

        System.out.println(min.get());

        System.out.println("-------------------");

        //max() method
        Optional<Integer> max = list.stream()
                .filter(integer -> integer % 2 == 0)
                .max(Comparator.naturalOrder()); //it's needed to specify how to compare the elements

        System.out.println(max.get());

        System.out.println("-------------------");

        //collect() method with Collectors.toList() to create a new list
        List<Integer> newList = list.stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * 3)
                .collect(Collectors.toList());

        System.out.println(newList);

        System.out.println("-------------------");

        //collect() method with Collectors.groupingBy() to group elements by maps
        //this one grouped true as even and false as odd because of the validation (as a conditional clause) being passed
        //in the groupingBy param, which will return a boolean
        Map<Boolean, List<Integer>> map = list.stream()
                                    .map(integer -> integer * 3)
                                    .collect(Collectors.groupingBy(integer -> integer % 2 == 0));

        System.out.println(map);

        System.out.println("-------------------");

        //the same as the one above, just another insight
        Map<Integer, List<Integer>> map2 = list.stream()
                .map(integer -> integer * 3)
                .collect(Collectors.groupingBy(integer -> integer % 3));

        System.out.println(map);

        System.out.println("-------------------");

        //collect() method with Collectors.joining()
        //this one only works with Strings
        String string = list.stream()
                .map(integer -> String.valueOf(integer))
                .collect(Collectors.joining());

        System.out.println(string);

        System.out.println("-------------------");

        //it works with delimiters too
        //when trying to convert elements of the list to a csv model for exemple
        String stringCsv = list.stream()
                .map(integer -> String.valueOf(integer))
                .collect(Collectors.joining(";"));

        System.out.println(stringCsv);

        System.out.println("-------------------");

    }
}
