package step2.lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step2.lotto.model.Count;
import step2.lotto.model.LottoMachine;
import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;

public class LottoApp {

    private static final Money LOTTO_PRICE = new Money(1000);
    private static final LottoMachine lottoMachine = new LottoMachine();

    private final Count match3TicketCount = null;
    private final Count match4TicketCount = null;
    private final Count match5TicketCount = null;
    private final Count match6TicketCount = null;

    public LottoTicketList buyLottoTickets(Money purchaseAmount) {
        Count ticketCount = new Count(purchaseAmount.value() / LOTTO_PRICE.value());
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount.value(); i++) {
            lottoTickets.add(lottoMachine.issueLottoTicket());
        }
        return new LottoTicketList(lottoTickets);
    }

    public Count calculateLottoTicketsCountOfMatchTargetCount(LottoTicket lastWeekWinningNumbers,
        LottoTicketList lottoTickets, Count targetCount) {
        Collections.sort(lastWeekWinningNumbers.value());
        LottoTicket sortedLastWeekWinningNumbers = new LottoTicket(lastWeekWinningNumbers.value());

        Count lottoTicketsCountOfMatchTargetCount = new Count(0);
        lottoTickets.value().stream().filter(
                lottoTicket -> isLottoTicketMatchTargetCount(sortedLastWeekWinningNumbers, lottoTicket, targetCount))
            .forEach(i -> lottoTicketsCountOfMatchTargetCount.increase());
        return lottoTicketsCountOfMatchTargetCount;
    }

    public boolean isLottoTicketMatchTargetCount(LottoTicket lastWeekWinningNumbers, LottoTicket lottoTicket,
        Count targetCount) {
        Count matchCount = new Count(0);
        lottoTicket.value().stream().filter(lastWeekWinningNumbers.value()::contains)
            .forEach(i -> matchCount.increase());
        return matchCount.equals(targetCount);
    }


}
