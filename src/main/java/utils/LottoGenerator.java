package utils;

import java.util.*;

public class LottoGenerator {
    private static List<Integer> numbers;
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    public static List<Integer> generateNumberList(int lottoCount) {
        numbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers, new Random());
        numbers = numbers.subList(0, lottoCount);
        Collections.sort(numbers);
        return numbers;
    }
}
