package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

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
        validateNumberCount(lottoNumber);
        validateDuplicatedNumbers(lottoNumber);
        validateNegativeOrZero(lottoNumber);
    }

    private static void validateNumberCount(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("로또 숫자입력이 올바르지 않습니다.(유효한 개수: 6개)");
        }
    }

    private static void validateDuplicatedNumbers(List<Integer> lottoNumber) {
        if (lottoNumber.size() != new HashSet<>(lottoNumber).size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 포함되어있습니다.");
        }
    }

    private void validateNegativeOrZero(List<Integer> lottoNumber) {
        lottoNumber.stream()
                .filter(isNegativeOrZero())
                .findAny()
                .ifPresent(a -> {
                    throw new IllegalArgumentException("로또에 음수나 0을 입력하실 수 없습니다.");
                });
    }

    private Predicate<Integer> isNegativeOrZero() {
        return n -> Integer.signum(n) < 1;
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