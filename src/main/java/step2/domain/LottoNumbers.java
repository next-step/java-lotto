package step2.domain;

import java.util.Collections;
import java.util.Set;

public class LottoNumbers {

    private final Set<LottoNumber> myWinningNumbers;

    public LottoNumbers(Set<LottoNumber> winningNumbers) {
        this.myWinningNumbers = winningNumbers;
    }

    public Set<LottoNumber> winningNumbers() {
        return Collections.unmodifiableSet(myWinningNumbers);
    }
}
