package io.cooper;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created by skehtch on 2/27/17.
 */
public class AppTest {

    @Test
    public void anonymousFunctionTest(){

        Thread thread = new Thread(() -> System.out.println("Hello World!"));

        thread.start();

    }

    @Test
    public void calculateSumInList(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertEquals(6, getTotal(numbers, number -> number % 2 == 0));
        assertEquals(9, getTotal(numbers, number -> number % 2 != 0));
    }

    private int getTotal(List<Integer> numbers, Predicate<Integer> predicate) {

        return numbers
                .stream()
                .filter(predicate)
                .mapToInt(e -> e)
                .sum();

    }
}