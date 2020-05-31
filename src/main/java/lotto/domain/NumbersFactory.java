package lotto.domain;

import lotto.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class NumbersFactory {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private static final String DELIMITER_PATTERN = ", ";
    private static final List<LottoNumber> NUMBERS_REPOSITORY = initializeNumbersRepository();

    private NumbersFactory() {
    }

    public static List<LottoNumber> createNonDuplicateNumbers(int lottoNumbersCount) {
        shuffleNumbers();

        return NUMBERS_REPOSITORY.stream()
                .limit(lottoNumbersCount)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void shuffleNumbers() {
        Collections.shuffle(NUMBERS_REPOSITORY);
    }

    public static List<LottoNumber> createManualNumbers(String manualNumbers) {
        return Arrays.stream(manualNumbers.split(DELIMITER_PATTERN))
                .map(manualNumber -> LottoNumber.newInstance(StringUtils.toInt(manualNumber)))
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> initializeNumbersRepository() {
        return IntStream.range(START_NUMBER, END_NUMBER)
                .mapToObj(LottoNumber::newInstance)
                .collect(Collectors.toList());
    }
}
