package domain;

import java.util.*;
import java.util.stream.Collectors;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTERY_NUMBER_SIX = 6;

    private RandomNumber() {
    }

    public static List<Integer> sixRandomNumber() {
        return removeOverlap().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static Set<Integer> removeOverlap() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != LOTTERY_NUMBER_SIX) {
            numbers.add(random());
        }
        return numbers;
    }

    public static int random() {
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }
}
