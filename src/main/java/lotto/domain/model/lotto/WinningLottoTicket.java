package lotto.domain.model.lotto;

import java.util.Objects;
import java.util.Set;

public class WinningLottoTicket extends LottoTicket {

    private final LottoNumber bonusNumber;

    public WinningLottoTicket(final Set<LottoNumber> winingNumbers, final LottoNumber bonusNumber) {
        super(winingNumbers);
        validateBonusNumber(winingNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoNumber getBonusNumber() {
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
