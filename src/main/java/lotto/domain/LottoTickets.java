package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(BuyCount buyCount, LottoTicketMaker lottoTicketMaker) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while(buyCount.canBuy()) {
            lottoTickets.add(LottoTicket.create(lottoTicketMaker));
            buyCount.subtract();
        }

        return new LottoTickets(lottoTickets);
    }

    public int number() {
        return lottoTickets.size();
    }

    public Stream<LottoTicket> stream() {
        return this.lottoTickets.stream();
    }

    public WinningResult getWinningResult(WinningLotto winningLotto) {
        return this.lottoTickets.stream()
                .map(winningLotto::getWinningRank)
                .collect(collectingAndThen(groupingBy(Function.identity(), counting()), WinningResult::of));
    }
}
