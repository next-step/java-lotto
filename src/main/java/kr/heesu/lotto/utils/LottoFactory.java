package kr.heesu.lotto.utils;

import kr.heesu.lotto.domain.Lotto;
import kr.heesu.lotto.domain.MultipleLotto;
import kr.heesu.lotto.domain.PurchaseAmount;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final int SIZE = 6;
    private static final List<Integer> RANGE;

    static {
        RANGE = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(RANGE);
        return RANGE.subList(0, SIZE);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return Lotto.of(numbers);
    }

    public static MultipleLotto createMultipleLottos(PurchaseAmount amount) {
        return MultipleLotto.of(amount);
    }
}
