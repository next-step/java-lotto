package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

import java.util.Objects;

public class WinningLotto {

    private final LottoTicket winningTicket;

    private WinningLotto(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public static WinningLotto of(LottoTicket winningTicket) {
        return new WinningLotto(winningTicket);
    }

    public boolean winningMatch(LottoNumber number) {
        return winningTicket.match(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningTicket, that.winningTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winningTicket);
    }
}
