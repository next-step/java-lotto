package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private static final int START = 1;
    private static final int END = 45;

    private LottoNumbers() {
    }

    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = START; i < END; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
