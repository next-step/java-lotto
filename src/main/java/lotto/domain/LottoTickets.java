package lotto.domain;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Rank, Long> matchResult(final WinningNumber winningNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchRank(winningNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static LottoTickets of(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        return new LottoTickets(Stream.of(manualLottoTickets, autoLottoTickets)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public int size() {
        return lottoTickets.size();
    }

}
