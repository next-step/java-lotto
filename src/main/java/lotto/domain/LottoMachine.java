package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    public static List<LottoTicket> buyLottoTickets(Money amount, List<LottoTicket> manualTickets) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount, manualTickets.size());

        List<LottoTicket> lottoTickets = Stream.generate(LottoTicket::createLottoTicketByAuto)
                .limit(lottoPurchaseAmount.getAutoTicketCount())
                .collect(Collectors.toCollection(ArrayList::new));

        lottoTickets.addAll(manualTickets);
        return lottoTickets;
    }

    public static List<LottoTicket> buyLottoTickets(long amount) {
        List<LottoTicket> empty = new ArrayList<>();
        return buyLottoTickets(new Money(amount), empty);
    }
}
