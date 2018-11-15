package lotto.util;

import java.util.*;

public class LotteryNumberGenerator {
    private static final int MAX_NUMBER = 45;
    private static final int QUANTITY = 6;

    public static Set<Integer> generate() {
        return new HashSet<>(sort(pick(shuffle(getNumbers()))));
    }

    private static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Integer> pick(List<Integer> numbers) {
        return numbers.subList(0, QUANTITY);
    }

    private static List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
