package lottery.domain;

import lottery.code.WinPrizeType;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoTickets {

    private final ManualTickets manualTickets;

    private final QuickTickets quickTickets;

    public LottoTickets(ManualTickets manualTickets,
                        QuickTickets quickTickets) {
        this.manualTickets = manualTickets;
        this.quickTickets = quickTickets;
    }

    public LottoTickets(ManualTickets manualTickets) {
        this(manualTickets, new QuickTickets(Collections.emptyList()));
    }

    public LottoTickets(QuickTickets quickTickets) {
        this(new ManualTickets(Collections.emptyList()), quickTickets);
    }

    public Map<WinPrizeType, Long> winStatistics(WinningLotto winningLotto) {
        return lottoTickets().stream()
                .collect(Collectors.groupingBy(
                        lottoTicket -> WinPrizeType.fromMatchCountWithBonusMatch(
                                lottoTicket.matchNumbersCount(winningLotto.winningNumbers()),
                                lottoTicket.matchNumber(winningLotto.bonusNumbers())),
                        Collectors.counting()));
    }

    public Long quickTicketCount(){
        return this.quickTickets.ticketCount();
    }

    public Long manualTicketCount(){
        return this.manualTickets.ticketCount();
    }

    public List<LottoTicket> lottoTickets() {
        return Stream.concat(quickTickets.quickTickets().stream(), manualTickets.manualTickets().stream())
                .collect(Collectors.toUnmodifiableList());
    }

    public Integer lottoTicketsTotalPrize(Map<WinPrizeType, Long> matchStatistics){
        return matchStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().prize() * entry.getValue().intValue())
                .sum();
    }

    public Integer lottoTicketsTotalPrice(){
        return Math.toIntExact(totalTicketCount() * LottoTicket.PRICE);
    }

    private Long totalTicketCount(){
        return manualTickets.ticketCount() + quickTickets.ticketCount();
    }
}
