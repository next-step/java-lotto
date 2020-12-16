package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.machine.TicketMachine;

public class LottoTickets {

    public static final Integer TICKET_PRICE = 1_000;
    private final List<LottoTicket> lottoTickets;

//    @Deprecated
//    public LottoTickets(int money, TicketMachine ticketMachine) {
//        this.lottoTickets = issueTickets(toTicketCount(money), ticketMachine);
//    }

    LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public MatchResult match(WinningTicket lastWinningTicket) {
        Map<MatchCount, Integer> matchResult = lottoTickets.stream()
              .map(lastWinningTicket::match)
              .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
        return new MatchResult(matchResult);
    }

//    @Deprecated
//    private int toTicketCount(int money) {
//        validateMoney(money);
//        return money / TICKET_PRICE;
//    }
//
//    @Deprecated
//    private void validateMoney(int money) {
//        if (money < TICKET_PRICE) {
//            throw new IllegalArgumentException("금액이 부족합니다.");
//        }
//    }
//
//    @Deprecated
//    private List<LottoTicket> issueTickets(int ticketCount, TicketMachine ticketMachine) {
//        return ticketMachine.issue(ticketCount);
//    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
