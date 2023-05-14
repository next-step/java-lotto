package lotto;

import java.util.List;
import java.util.Set;
import java.util.function.LongToDoubleFunction;

public class WinNumber {

    private final Lotto winNumbers;
    private final LottoNumber bonusNumber;

    public WinNumber(Set<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = new Lotto(winNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    public List<LottoNumber> getWinNumbers() {
        return this.winNumbers.getNumbers();
    }
}
