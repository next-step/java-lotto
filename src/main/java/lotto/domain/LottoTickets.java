package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult getLottoResult(WinningNumbers winningNumbers) {
        Map<Integer, Integer> lottoStatistics = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.getMatchCount(winningNumbers))
                .collect(groupingBy(Function.identity(), reducing(0, e -> 1, Integer::sum)));

        return new LottoResult(lottoStatistics);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
