package lotto.domain;

import java.util.Objects;

public class LottoDiscriminator {
    private final LottoTicket winningTicket;

    public LottoDiscriminator(final LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public int matchingCount(final LottoTicket lottoTicket) {
        return lottoTicket.matchingLottoNumbersCount(winningTicket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoDiscriminator that = (LottoDiscriminator) o;
        return Objects.equals(winningTicket, that.winningTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningTicket);
    }
}
