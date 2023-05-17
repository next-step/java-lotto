package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    public static List<LottoTicket> buyLottoTickets(Money amount) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount);

        return Stream.generate(LottoTicket::createLottoTicketByAuto)
                .limit(lottoPurchaseAmount.getTicketCount())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<LottoTicket> buyLottoTickets(long amount) {
        return buyLottoTickets(new Money(amount));
    }
}
