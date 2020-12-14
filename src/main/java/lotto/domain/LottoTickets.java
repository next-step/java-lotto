package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    public static final Integer TICKET_PRICE = 1_000;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int money, TicketMachine ticketMachine) {
        this.lottoTickets = issueTickets(toTicketCount(money), ticketMachine);
    }

    LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public MatchResult match(LottoTicket lastWinningTicket) {
        Map<Integer, Integer> matchResult = lottoTickets.stream()
              .map(lottoTicket -> lottoTicket.matchCount(lastWinningTicket))
              .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
        return new MatchResult(matchResult);
    }

    private int toTicketCount(int money) {
        validateMoney(money);
        return money / TICKET_PRICE;
    }

    private void validateMoney(int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    private List<LottoTicket> issueTickets(int ticketCount, TicketMachine ticketMachine) {
        return ticketMachine.issue(ticketCount);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
