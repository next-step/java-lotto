package lotto.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(BuyCount buyCount, LottoTicketMaker lottoTicketMaker) {
        List<LottoTicket> lottoTickets = lottoTicketMaker.create(buyCount);

        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets merge(LottoTickets selectLottoTickets, LottoTickets autoLottoTickets) {
        return Stream.concat(
                selectLottoTickets.getLottoTickets().stream(),
                autoLottoTickets.getLottoTickets().stream())
                .collect(collectingAndThen(Collectors.toList(), LottoTickets::new));
    }

    public int getSize() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public WinningResult getWinningResult(WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(winningLotto::getWinningRank)
                .collect(collectingAndThen(groupingBy(Function.identity(), counting()), WinningResult::of));
    }
}
