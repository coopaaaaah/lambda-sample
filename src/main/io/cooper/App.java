package io.cooper;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by skehtch on 2/24/17.
 */
public class App {
    public static void main(String[] args) {

        // this creates anonymous classes when compiled ( increasing your jar file size )
        Thread th = new Thread(() -> System.out.println("Greetings"));

        // convert to lambda expression by removing the ceremony
        // paramaters -> body of the function
        // () -> sout("Greetings")

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer evenSum = calculateSumOfAllEvenNumbers(numbers);
        Integer evenSumFromPredicate = calcSum(numbers, isEven());
        Integer oddSum = calcSum(numbers, isOdd());

        th.start();

    }

    private static Integer calculateSumOfAllEvenNumbers(List<Integer> numbers) {

        int total = 0;

        for(Integer number : numbers)
            if (number % 2 == 0)
                total += number;

        return total;

    }

    private static Integer calcSum(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers
                .stream()
                .filter(predicate)
                .mapToInt(e -> e)
                .sum();
    }

    private static Predicate<Integer> isOdd() {
        return e -> e % 2 != 0;
    }

    private static Predicate<Integer> isEven() {
        return e -> e % 2 == 0;
    }

}