package lotto;

import lotto.lotto.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class LottoMachine {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private LottoMachine() {
    }

    public static LottoNumbers generateLottoNumber() {
        List<Integer> pickedLottoNumbers = pickLottoNumbers();
        return LottoNumbers.from(pickedLottoNumbers);
    }

    private static List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbersRange = rangeClosed(MIN_VALUE, MAX_VALUE).boxed().collect(toList());
        Collections.shuffle(lottoNumbersRange);

        return lottoNumbersRange.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
