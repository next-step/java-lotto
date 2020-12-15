package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;

    private WinningLotto(LottoTicket winningLottoTicket) {
        this.winningLottoTicket = winningLottoTicket;
    }

    public static WinningLotto ofLottoNumbers(LottoTicket lottoTicket) {
        return new WinningLotto(lottoTicket);
    }

    public LottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLottoTicket, that.winningLottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoTicket);
    }
}
