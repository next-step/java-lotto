package lotto.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WinningTicket extends LottoTicket {

    private LottoNumber bonusNumber;

    public WinningTicket(String numbers, String bonus) {
        super(numbers);
        addBonusNumber(bonus);
    }

    WinningTicket(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public MatchCount match(LottoTicket userLottoTicket) {
        Set<LottoNumber> compareLottoTicket = new HashSet<>(this.lottoNumbers);
        Set<LottoNumber> userLottoNumbers = userLottoTicket.lottoNumbers;

        compareLottoTicket.retainAll(userLottoNumbers);
        int matchCount = compareLottoTicket.size();
        boolean isBonusMatch = userLottoNumbers.contains(this.bonusNumber);

        return MatchCount.getResult(matchCount, isBonusMatch);
    }

    private void addBonusNumber(String bonus) {
        LottoNumber bonusNumber = new LottoNumber(bonus);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoNumber bonusNumber) {
        if (super.lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨번호와 중복됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningTicket that = (WinningTicket) o;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
