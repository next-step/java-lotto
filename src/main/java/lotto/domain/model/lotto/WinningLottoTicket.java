package lotto.domain.model.lotto;

import java.util.Objects;
import java.util.Set;

public class WinningLottoTicket extends LottoTicket {

    private final BonusNumber bonusNumber;

    public WinningLottoTicket(final Set<LottoNumber> winningNumbers, final BonusNumber bonusNumber) {
        super(winningNumbers);
        bonusNumber.validateNotInWinningNumbers(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WinningLottoTicket that = (WinningLottoTicket) o;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonusNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", 보너스: " + bonusNumber;
    }
}
