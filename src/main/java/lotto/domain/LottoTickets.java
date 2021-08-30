package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    private LottoTickets(List<LottoTicket> lottoTickets1, List<LottoTicket> lottoTickets2) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(lottoTickets1);
        lottoTickets.addAll(lottoTickets2);
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets of(LottoTickets lottoTickets1, LottoTickets lottoTickets2) {
        return new LottoTickets(lottoTickets1.lottoTickets, lottoTickets2.lottoTickets);
    }

    public WinStatistics calculateStatistics(WinnerNumbers winnerNumbers) {
        return WinStatistics.from(lottoTickets.stream()
            .collect(Collectors.groupingBy(winnerNumbers::decideRank, Collectors.summingInt(s -> 1)))
        );
    }

    public List<LottoTicket> toList() {
        return lottoTickets;
    }
}
