package lotto.util;

import java.util.*;

public class LotteryNumberGenerator {
    private static int MAX_NUMBER = 45;
    private static int QUANTITY = 6;

    public static Set<Integer> generate() {
        List<Integer> numbers = getNumbers();
        Collections.shuffle(numbers);
        return new HashSet<>(numbers.subList(0, QUANTITY));
    }

    private static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
