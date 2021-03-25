package lotto.domain;

import java.util.Objects;

public class LottoDiscriminator {
    private final LottoTicket winningTicket;

    public LottoDiscriminator(final LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    // TODO: 연관된 기능 수정하고, 지워야 함.
    public int matchingCount(final LottoTicket lottoTicket) {
        return lottoTicket.matchingLottoNumbersCount(winningTicket);
    }

    public LottoRank lottoRank(LottoTicket lottoTicket) {
        return LottoRank.valueOf(
                winningTicket.matchingLottoNumbersCount(lottoTicket),
                winningTicket.sameBonusNumber(lottoTicket)
        );
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
