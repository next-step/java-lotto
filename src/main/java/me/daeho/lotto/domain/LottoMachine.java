package me.daeho.lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int unitPrice;
    private final WinningPrize winningPrize;

    private LottoMachine(int unitPrice, WinningPrize winningPrize) {
        this.unitPrice = unitPrice;
        this.winningPrize = winningPrize;
    }

    public static LottoMachine create(int unitPrice, WinningPrize winningPrize) {
        return new LottoMachine(unitPrice, winningPrize);
    }

    public List<LottoTicket> buyRandom(int amount) {
        int count = amount / unitPrice;

        return IntStream.range(0, count)
                .mapToObj(v -> LottoTicket.issue(RandomLottoNumber.make()))
                .collect(Collectors.toList());
    }

    public int totalPrize(Map<Integer, Integer> matchTicketCounts) {
        int totalPrize = 0;
        for(Map.Entry<Integer, Integer> entry : matchTicketCounts.entrySet()) {
            totalPrize += winningPrize.prize(entry.getKey()) * entry.getValue();
        }
        return totalPrize;
    }

    public Map<Integer, Integer> matchTicketCounts(List<LottoNumber> lastWinningNumber, List<LottoTicket> tickets) {
        final Map<Integer, Integer> matchNumbers = new HashMap<>();
        tickets.forEach(t -> {
            int matchCount = t.containsCount(lastWinningNumber);
            matchNumbers.put(matchCount, increaseMatchTicketCount(matchNumbers, matchCount));
        });
        return matchNumbers;
    }

    private int increaseMatchTicketCount(Map<Integer, Integer> matchNumbers, int matchCount) {
        return matchNumbers.getOrDefault(matchCount, 0) + 1;
    }

    public double earningRate(int amount, int totalPrize) {
        return BigDecimal.valueOf(totalPrize)
                .divide(BigDecimal.valueOf(amount), 2, BigDecimal.ROUND_UP)
                .doubleValue();
    }
}
