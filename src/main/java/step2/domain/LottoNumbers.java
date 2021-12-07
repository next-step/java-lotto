package step2.domain;

import java.util.Collections;
import java.util.Set;

public class WinningNumbers {

    private final Set<LottoNumber> myWinningNumbers;

    public WinningNumbers(Set<LottoNumber> winningNumbers) {
        this.myWinningNumbers = winningNumbers;
    }

    public Set<LottoNumber> winningNumbers() {
        return Collections.unmodifiableSet(myWinningNumbers);
    }
}
