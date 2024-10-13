package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumbers {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final List<Integer> randomLottoNumbers = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            randomLottoNumbers.add(i);
        }
    }

    public static List<Integer> generateAutoLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(randomLottoNumbers);
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
