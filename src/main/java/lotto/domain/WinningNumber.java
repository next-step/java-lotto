package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final int WINNING_NUMBER = 6;
    public static List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumberList) {
        validNumber(winningNumberList);
        this.winningNumber = winningNumberList;
    }

    public static void stringToNumber(String[] winningNumbers) {
        new WinningNumber(Arrays.stream(winningNumbers)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
    }

    public static void validNumber(List<Integer> winningNumberList) {
        if (winningNumberList.size() != WINNING_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 여섯개를 입력해야 합니다.");
        }
    }

    @Override
    public String toString() {
        return "" + winningNumber;
    }
}
