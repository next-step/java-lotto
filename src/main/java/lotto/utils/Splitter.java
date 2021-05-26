package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoOptions.LOTTO_SIZE;

/**
 * 콤마를 기준으로 스플릿하는 객체
 */
public final class Splitter {
    private static final String DEFAULT_SEPARATOR = "[,]";
    public static final String INVALID_LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개의 숫자로 이루어져야 합니다.";
    public static final String INVALID_INPUT_VALUE_ERROR_MESSAGE = "숫자가 아닌 값을 넣을 수 없습니다.";

    public static List<LottoNumber> split(final String answerLottoNumbers) {
        final List<LottoNumber> lottoNumbers = makeLottoNumbers(answerLottoNumbers);
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR_MESSAGE);
        }
        return lottoNumbers;
    }

    private static List<LottoNumber> makeLottoNumbers(final String answerLottoNumbers) {
        return Arrays.stream(answerLottoNumbers.split(DEFAULT_SEPARATOR))
                .map(String::trim)
                .map(Splitter::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE_ERROR_MESSAGE);
        }
    }
}
