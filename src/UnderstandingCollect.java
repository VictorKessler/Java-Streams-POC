import java.util.*;
import java.util.stream.Collectors;

// used for mutable objects
public class UnderstandingCollect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // supplier -> instance of what may be used to store the data
        // accumulator -> how to store the data
        // combiner -> what to do after stored
        Set<String> collect = list.stream()
                .collect(() -> new HashSet<>(),
                        (l, e) -> l.add(e.toString()),
                        (l1, l2) -> l1.addAll(l2));

        System.out.println(list);
        System.out.println(collect);

        System.out.println("-------------------");

        List<Integer> collect2 = list.stream()
                .collect(Collectors.toList());

        System.out.println(collect2);

        System.out.println("-------------------");

        Set<Integer> collect3 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toSet());

        System.out.println(collect3);

        System.out.println("-------------------");

        // use the collection you want
        Deque<Integer> collect4 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        System.out.println(collect4);

        System.out.println("-------------------");

        // only works with strings
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining());

        System.out.println(join);

        System.out.println("-------------------");

        // averaging
        Double avg = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));

        System.out.println(avg);

        System.out.println("-------------------");

        // summing
        Integer sum = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));

        System.out.println(sum);

        System.out.println("-------------------");

        // summarizing
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));

        String res = String.format("IntSummaryStatistics: %.2f, %d, %d, %d, %d",
                stats.getAverage(),
                stats.getCount(),
                stats.getMax(),
                stats.getMin(),
                stats.getSum());

        System.out.println(res);

        System.out.println("-------------------");

        // counting
        Long count = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("-------------------");

        // max/min
        Optional<Integer> max = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()));

        System.out.println(max);

        System.out.println("-------------------");

        //  grouping by
        Map<Integer, List<Integer>> groupBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));

        System.out.println(groupBy);

        System.out.println("-------------------");

        //partitioningBy
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy(((n) -> n % 2 == 0)));

        System.out.println(partitioningBy);

        System.out.println("-------------------");

        //toMap -> first argument determine what will be the key, second argument works on the value to be stored in the key
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors.toMap(
                        (n -> n),
                        n -> n * 2)
                );

        System.out.println(toMap);
    }
}
