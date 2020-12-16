package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public MatchResult match(WinningTicket lastWinningTicket) {
        Map<MatchCount, Integer> matchResult = lottoTickets.stream()
              .map(lastWinningTicket::match)
              .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
        return new MatchResult(matchResult);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
