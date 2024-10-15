package lotto.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomizer {

    private static final int MIN_ISSUE_NUMBER = 0;
    private static final int MAX_ISSUE_NUMBER = 6;

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static List<Integer> create() {
        List<Integer> initNumbers = init();
        Collections.shuffle(initNumbers);
        return initNumbers.subList(MIN_ISSUE_NUMBER, MAX_ISSUE_NUMBER);
    }

    private static List<Integer> init() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
