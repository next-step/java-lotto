package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(LottoTicket... lottoTicket) {
        this(Arrays.asList(lottoTicket));
    }

    public List<LottoRank> checkRank(WinningTicket winningNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkPrize(winningNumber))
                .collect(toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTickets)) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
