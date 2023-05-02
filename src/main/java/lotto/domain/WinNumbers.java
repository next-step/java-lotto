package lotto.domain;

import java.util.Set;

public class WinNumbers {
    private final Set<Integer> winNumbers;

    public WinNumbers(Set<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public boolean contain(int number) {
        return winNumbers.contains(number);
    }
}
