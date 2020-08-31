package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        LottoTickets lottoTickets = new LottoTickets(autoLottoTickets);
        lottoTickets.lottoTickets.addAll(manualLottoTickets);
        return lottoTickets;
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public int size() {
        return lottoTickets.size();
    }

}
