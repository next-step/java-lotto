package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusBall;

    public WinningNumbers(String number, int bonusBall) {
        this(winningNumber(number), bonusBall);
    }

    public WinningNumbers(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    private static List<Integer> winningNumber(String lottoNumber) {
        return Arrays.stream(lottoNumber.replace(" ", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
