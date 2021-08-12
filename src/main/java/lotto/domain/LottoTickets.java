package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets(){
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoResult getMatchRankCount(WinningLottoTicket winningLottoTicket) {
        return LottoResult.of(lottoTickets.stream()
                .collect(Collectors.groupingBy(winningLottoTicket::match, Collectors.counting())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
