package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.LottoNumbers.LOTTO_SIZE;

public class LottoMachine {
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoMachine() {
    }

    public static LottoNumbers generateLottoNumber() {
        ArrayList<LottoNumber> numbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(numbers);

        return new LottoNumbers(numbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toSet())
        );
    }
}