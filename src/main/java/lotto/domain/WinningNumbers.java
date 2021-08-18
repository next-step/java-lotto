package lotto.domain;

import java.util.Objects;

public class WinningNumbers{

    private final LottoTicket winningTicket;

    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningTicket, that.winningTicket) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningTicket, bonusNumber);
    }

    public boolean contains(LottoNumber element) {
        return winningTicket.contains(element);
    }

    public boolean containsBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
