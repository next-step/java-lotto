package lotto.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.model.LottoNumber;

public final class LottoNumberGenerator {

    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER_BOUND = 46;
    private static final int COUNT_TO_PICK = 6;
    private static List<LottoNumber> initLottoNumbers;

    static {
        initLottoNumbers = IntStream.range(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER_BOUND)
                                    .mapToObj(LottoNumber::new)
                                    .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static List<LottoNumber> generate() {
        List<LottoNumber> sortedInitLottoNumbers = initLottoNumbers.stream()
                                                                   .sorted(Comparator.comparing(LottoNumber::getValue))
                                                                   .collect(Collectors.toList());
        return pickNumbers(sortedInitLottoNumbers);
    }

    private static List<LottoNumber> pickNumbers(List<LottoNumber> allLottoNumbers) {
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.stream()
                              .limit(COUNT_TO_PICK)
                              .sorted(Comparator.comparing(LottoNumber::getValue))
                              .collect(Collectors.toList());
    }
}
