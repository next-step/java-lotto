package step4.domain.lotto.firstcollection;

import step4.Constant;
import step4.domain.lotto.LottoTicket;
import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.strategy.NumberMakeStrategy;
import step4.type.LottoType;
import step4.type.WinningType;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {
    public static final int START_INDEX = 0;
    private final List<LottoTicket> tickets;

    public LottoTickets(int count, NumberMakeStrategy strategy) {
        tickets = makeAutoTickets(count, strategy);
    }

    public LottoTickets(List<LottoTicket> tickets, List<LottoTicket> manualTickets) {
        this.tickets = Stream.of(tickets, manualTickets)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public LottoTickets(LottoPurchaseInfoDTO info, NumberMakeStrategy strategy) {
        List<LottoTicket> manuals = makeManualTickets(info.getManualNumbers());
        List<LottoTicket> autos = makeAutoTickets(info.getAutoTicketsSize(), strategy);
        tickets = Stream.of(manuals, autos)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> makeAutoTickets(int count, NumberMakeStrategy strategy) {
        return IntStream.range(START_INDEX, count)
                .mapToObj(index -> new LottoTicket(strategy))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> makeManualTickets(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public int countTickets() {
        return tickets.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        tickets.forEach(ticket -> sb.append(ticket.toString())
                .append(System.lineSeparator())
        );

        return sb.toString();
    }

    public Map<WinningType, Long> countByWinningType(WinningNumbers winningNumbers) {
        return tickets.stream()
                .map(ticket -> ticket.compareWinningNumber(winningNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public long countTicketByLottoType(LottoType type) {
        return tickets.stream()
                .filter(ticket-> ticket.equalsType(type))
                .count();
    }

    public double getExpenses() {
        return tickets.size() * Constant.LOTTO_PRICE;
    }
}
