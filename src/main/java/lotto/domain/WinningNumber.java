package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber = new ArrayList<>();

    public void convertStringToIntList(String stringWinningNumber) {
        Arrays.stream(splitString(stringWinningNumber))
                .map(Integer::parseInt)
                .forEach(winningNumber::add);
    }

    private String[] splitString(String stringWinningNumber) {
        return stringWinningNumber.split(", ");
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
