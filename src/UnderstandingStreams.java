import java.util.Arrays;
import java.util.List;

public class UnderstandingStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);

        //Before Java 8

        for (Integer integer :
             list) {
            System.out.println(integer);
        }

        System.out.println("---------------------");

        // After Java 8

        list.stream().forEach(integer -> System.out.println(integer));

    }
}
