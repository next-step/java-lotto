package lotto.domain;

import java.util.Objects;

public class WinningTicket {
    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningTicket(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new BonusNumber(lottoNumbers, bonusNumber);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isMatchBonusNumber(LottoNumber winningNumber) {
//        return winningNumber.getLottoNumber()
//                .stream()
//                .filter(this::isMatchBonusNumber)
//                .count() == 1;
        return true;
    }

    private boolean isMatchBonusNumber(int number) {
        return bonusNumber.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningTicket)) return false;
        WinningTicket that = (WinningTicket) o;
        return getLottoNumbers().getLottoNumbers().containsAll(that.getLottoNumbers().getLottoNumbers()) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers(), bonusNumber);
    }
}
