package lotto.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    private RandomNumberGenerator(){}

    public static Set<Integer> generateNumberSet(int min, int max, int cnt){
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < cnt){
            numbers.add(generateNumber(min, max));
        }

        return numbers;
    }

    private static Integer generateNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
