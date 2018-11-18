package lotto.util;

import lotto.LottoConstants;

import java.util.*;

public class LotteryNumberGenerator {

    public static List<Integer> generate() {
        return sort(pick(shuffle(getNumbers())));
    }

    private static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= LottoConstants.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Integer> pick(List<Integer> numbers) {
        return numbers.subList(0, LottoConstants.QUANTITY);
    }

    private static List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
