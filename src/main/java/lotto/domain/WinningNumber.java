package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    public static List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        ExceptionHandler.validLottoNumberRange(winningNumber);
        ExceptionHandler.validLottoSize(winningNumber);
        this.winningNumber = winningNumber;
    }

    public static void stringToNumber(String[] winningNumbers) {
        new WinningNumber(Arrays.stream(winningNumbers)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "" + winningNumber;
    }
}
