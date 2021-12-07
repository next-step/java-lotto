package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class LottoMachine {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private LottoMachine() {
    }

    public static LottoNumbers generateLottoNumber() {
        List<Integer> pickedLottoNumbers = pickLottoNumbers();
        return LottoNumbers.from(pickedLottoNumbers);
    }

    private static List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbersRange = rangeClosed(MIN, MAX).boxed().collect(toList());
        Collections.shuffle(lottoNumbersRange);

        return lottoNumbersRange.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }
}
