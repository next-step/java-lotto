package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private List<Integer> winningNumbers;

    public WinningNumbers(String number) {
        this(new ArrayList<>(), number);
    }

    public WinningNumbers(List<Integer> winningNumbers, String number) {
        this.winningNumbers = winningNumbers;
        get(number);
    }

    public void get(String number) {
        Arrays.stream(number.split(",")).forEach(stringNumber -> winningNumbers.add(Integer.parseInt(stringNumber)));
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
