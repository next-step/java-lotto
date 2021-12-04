package step2.domain;

import step2.dto.WinningNumber;

import java.util.Collections;
import java.util.Set;

public class WinningNumbers {

    private final Set<WinningNumber> myWinningNumbers;

    public WinningNumbers(Set<WinningNumber> winningNumbers) {
        this.myWinningNumbers = winningNumbers;
    }

    public Set<WinningNumber> winningNumbers() {
        return Collections.unmodifiableSet(myWinningNumbers);
    }
}
