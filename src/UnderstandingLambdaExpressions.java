public class UnderstandingLambdaExpressions {
    public static void main(String[] args) {

        // Starting to understand Lambda Expressions

        // Before Java 8

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).run();

        // After Java 8

        new Thread(() -> System.out.println("Hello World!")).run();

        /*
         This is possible because of SAM principle (Single Abstract Method)
         Which can be understood as any interface/abstract class that has only one abstract method
        */

    }
}