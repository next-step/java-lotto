package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class LottoWinningNumber {

    private static final String NUMBER_DELIMITER = ",";
    private static final String CHAR_WHITE_SPACE = " ";

    private final List<Integer> lottoNumber;

    public LottoWinningNumber(List<Integer> lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumber(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("로또 숫자입력이 올바르지 않습니다.(유효한 개수: 6개)");
        }
    }

    public static LottoWinningNumber create(String winningNumberAsString) {
        String refinedWinningNumber = removeWhiteSpace(winningNumberAsString);
        return new LottoWinningNumber(toLottoNumber(refinedWinningNumber));
    }

    private static String removeWhiteSpace(String winningNumberAsString) {
        return winningNumberAsString.replace(CHAR_WHITE_SPACE, "");
    }

    private static List<Integer> toLottoNumber(String refinedWinningNumber) {
        return Arrays.stream(splitDelimiter(refinedWinningNumber))
                .map(Integer::parseInt)
                .collect(toUnmodifiableList());
    }

    private static String[] splitDelimiter(String refinedWinningNumber) {
        return refinedWinningNumber.split(NUMBER_DELIMITER);
    }

    public boolean contains(Integer number) {
        return lottoNumber.contains(number);
    }

}