package lotto.domain;

import java.util.*;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public final List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }
}
