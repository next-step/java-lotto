package step2.domain;

import step2.dto.WinningResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final int WINNING_BASE = 3;

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int lottoTicketsCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public WinningResult matchedWinningNumber(WinningNumbers winningNumbers) {
        Map<String, Long> winningCollect = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.containsWinningNumber(winningNumbers.winningNumbers()))
                .filter(number -> number >= WINNING_BASE)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        winningCollect.put("3", winningCollect.getOrDefault("3", 0L));
        winningCollect.put("4", winningCollect.getOrDefault("4", 0L));
        winningCollect.put("5", winningCollect.getOrDefault("5", 0L));
        winningCollect.put("6", winningCollect.getOrDefault("6", 0L));


        return new WinningResult(winningCollect);
    }
}
