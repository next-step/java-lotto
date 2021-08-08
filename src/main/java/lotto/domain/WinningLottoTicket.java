package lotto.domain;

import lotto.exception.InvalidBonusNumberException;

import java.util.List;
import java.util.Objects;

public class WinningLottoTicket {
    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusLottoNumber;

    private WinningLottoTicket(List<Integer> winningLottoNumberList, LottoNumber bonusLottoNumber) {
        this.winningLottoTicket = LottoTicket.of(winningLottoNumberList);
        this.bonusLottoNumber = bonusLottoNumber;
        validate();
    }

    public static WinningLottoTicket of(List<Integer> winningLottoNumberList, LottoNumber bonusLottoNumber) {
        return new WinningLottoTicket(winningLottoNumberList, bonusLottoNumber);
    }

    private void validate() {
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
