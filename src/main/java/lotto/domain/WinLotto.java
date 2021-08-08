package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinLotto {
    private LottoTicket winNumbers;
    private LottoNumber bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = new LottoTicket(winNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoTicket getWinNumbers() {
        return winNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinLotto winLotto = (WinLotto) o;
        return Objects.equals(winNumbers, winLotto.winNumbers) &&
                Objects.equals(bonusNumber, winLotto.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers, bonusNumber);
    }
}
