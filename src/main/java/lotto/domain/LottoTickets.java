package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public WinStatistics calculateStatistics(WinnerNumbers winnerNumbers) {
        return WinStatistics.from(lottoTickets.stream()
            .collect(Collectors.groupingBy(winnerNumbers::decideRank, Collectors.summingInt(s -> 1)))
        );
    }

}
