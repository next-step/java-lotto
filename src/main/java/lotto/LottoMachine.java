package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoConfig.LOTTO_NUMBER_SIZE;
import static lotto.LottoConfig.MAX_LOTTO_NUMBER;

public class LottoMachine {
    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, MAX_LOTTO_NUMBER + 1).boxed().collect(Collectors.toList());

    private LottoMachine() {
    }

    public static LottoNumber generateLottoNumber() {
        ArrayList<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(numbers);

        return new LottoNumber(numbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toSet())
        );
    }
}
