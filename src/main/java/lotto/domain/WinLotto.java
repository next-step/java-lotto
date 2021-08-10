package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinLotto {
    private LottoTicket winNumbers;
    private LottoNumber bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        if(winNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("보너스 볼이 당첨번호와 중복됩니다.");
        }
        this.winNumbers = new LottoTicket(winNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
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
