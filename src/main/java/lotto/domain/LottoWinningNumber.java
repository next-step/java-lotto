package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoRuleConfig.*;

public class LottoWinningNumber {

    private static final String STRING_SPACE_REGEX = "\\s";
    private final List<Integer> winningNumberList;

    public LottoWinningNumber(String winningNumbers) {
        this.winningNumberList = parseIntNumbers(noneSpaceStrings(winningNumbers));
    }

    public int sameNumberOfCount(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .mapToInt(i -> numberMatchResult(winningNumberList,i.getLottoNumber()))
                .filter(i -> i == 1)
                .count();
    }

    public boolean isMatchUpToBonusNumber(List<LottoNumber> lottoNumbers, int bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(e -> e.getLottoNumber() == bonusNumber);
    }

    private static void lottoNumberSizeException(int numberSize) {
        if(numberSize != MAX_LOTTO_BALL_COUNT)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);
    }

    private static int numberMatchResult(List<Integer> winningNumbers, int number) {
        return Collections.frequency(winningNumbers,number);
    }

    private static String noneSpaceStrings(String winningNumbers) {
        return winningNumbers.replaceAll(STRING_SPACE_REGEX,"");
    }

    private static List<Integer> parseIntNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(LOTTO_NUMBER_SEPARATOR);
        lottoNumberSizeException(numbers.length);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
