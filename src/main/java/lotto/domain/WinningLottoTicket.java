package lotto.domain;

import lotto.exception.InvalidBonusNumberException;

import java.util.List;
import java.util.Objects;

public class WinningLottoTicket {
    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusLottoNumber;

    private WinningLottoTicket(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
        validate(winningLottoTicket, bonusLottoNumber);
        this.winningLottoTicket = winningLottoTicket;
        this.bonusLottoNumber = bonusLottoNumber;

    }

    public static WinningLottoTicket of(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
        return new WinningLottoTicket(winningLottoTicket, bonusLottoNumber);
    }

    private void validate(LottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
        if (winningLottoTicket.contains(bonusLottoNumber)) {
            throw new InvalidBonusNumberException();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLottoTicket.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoTicket that = (WinningLottoTicket) o;
        return winningLottoTicket.equals(that.winningLottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoTicket);
    }

    public LottoRank match(LottoTicket compareLottoTicket) {
        int countOfMatch = winningLottoTicket.getCountOfMatch(compareLottoTicket);
        boolean bonusMatch = compareLottoTicket.contains(bonusLottoNumber);

        return LottoRank.valueOf(countOfMatch, bonusMatch);
    }
}
