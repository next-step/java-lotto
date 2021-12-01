package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

class ShuffleNumbersTest {
    @Test
    void generate() {
        List<Integer> numbers = ShuffleNumbers.generateSixNumbers();
        System.out.println(numbers);

        List<Integer> numbers1 = ShuffleNumbers.generateSixNumbers();
        System.out.println(numbers1);

        List<Integer> numbers2 = ShuffleNumbers.generateSixNumbers();
        System.out.println(numbers2);
    }
}