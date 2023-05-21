package lotto.auto.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumber {
    private final List<Integer> winNumbers;

    public WinNumber(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }
}
