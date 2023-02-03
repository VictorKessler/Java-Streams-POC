import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// used for immutable objects
public class UnderstandingReduce {
    public static void main(String[] args) {
        String string = "Lorem ipsum dolor sit amet";
        String[] split = string.split(" ");
        List<String> listStr = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        
        // reduce sum
        Optional<Integer> sum = list.stream()
                .reduce((n1, n2) -> n1 + n2);

        System.out.println(sum.get());

        System.out.println("-------------------");

        // reduce multiplication
        Optional<Integer> multiplication = list.stream()
                .reduce((n1, n2) -> n1 * n2);

        System.out.println(multiplication.get());

        System.out.println("-------------------");

        // reduce concatenation
        Optional<String> concatenation = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));

        System.out.println(concatenation.get());

        System.out.println("-------------------");

        // indentity value
        Integer sum2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        System.out.println(sum2);

        System.out.println("-------------------");

        Integer multiplication2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);

        System.out.println(multiplication2);

        System.out.println("-------------------");

        String concatenation2 = listStr.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));

        System.out.println(concatenation2);

        System.out.println("-------------------");

        // map + combiner
        //gonna combine using the values of each "group" after the accumulator function
        String concatenationUsingIntegerList = list.stream()
                .reduce("",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );

        System.out.println(concatenationUsingIntegerList);
    }
}
