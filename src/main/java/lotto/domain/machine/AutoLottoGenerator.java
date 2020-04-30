package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numbers.add(i);
        }
    }

    public static Lotto createLotto() {
        Collections.shuffle(numbers);
        return Lotto.of(numbers.subList(0, 6));
    }
}
