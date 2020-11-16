package step4.domain.lotto.firstcollection;

import step4.domain.lotto.LottoTicket;
import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.strategy.NumberMakeStrategy;
import step4.type.WinningType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {
    public static final int START_INDEX = 0;
    private final List<LottoTicket> autoTickets;
    private final List<LottoTicket> manualTickets;

    public LottoTickets(int count, NumberMakeStrategy strategy) {
        autoTickets = makeAutoTickets(count, strategy);
        manualTickets = new ArrayList<>();
    }

    public LottoTickets(List<LottoTicket> autoTickets, List<LottoTicket> manualTickets) {
        this.autoTickets = autoTickets;
        this.manualTickets = manualTickets;
    }

    public LottoTickets(LottoPurchaseInfoDTO info) {
        this.manualTickets = makeManualTickets(info.getManualNumbers());
        this.autoTickets = makeAutoTickets(info.getAutoTicketsSize(), info.getStrategy());
    }

    private List<LottoTicket> makeAutoTickets(int count, NumberMakeStrategy strategy) {
        return  IntStream.range(START_INDEX, count)
                .mapToObj(index -> new LottoTicket(strategy))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> makeManualTickets(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public int countTickets() {
        return Integer.sum(countAutoTicket(), countManualTicket());
    }

    public int countAutoTicket() {
        return autoTickets.size();
    }
    public int countManualTicket() {
        return manualTickets.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Stream.of(manualTickets, autoTickets)
                .flatMap(List::stream)
                .forEach(ticket -> sb.append(ticket.toString())
                        .append(System.lineSeparator())
                );

        return sb.toString();
    }

    public Map<WinningType, Long> countByWinningType(WinningNumbers winningNumbers) {
        return Stream.of(autoTickets, manualTickets)
                .flatMap(List::stream)
                .map(ticket -> ticket.compareWinningNumber(winningNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

}
