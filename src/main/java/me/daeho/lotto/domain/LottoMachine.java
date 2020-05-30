package me.daeho.lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final LottoNumberRule lottoNumberRule;
    private final int unitPrice;

    private LottoMachine(LottoNumberRule lottoNumberRule, int unitPrice) {
        this.lottoNumberRule = lottoNumberRule;
        this.unitPrice = unitPrice;
    }

    public static LottoMachine create(LottoNumberRule lottoNumberRule, int unitPrice) {
        return new LottoMachine(lottoNumberRule, unitPrice);
    }

    public List<LottoTicket> buyRandom(int amount) {
        int count = amount / unitPrice;

        return IntStream.range(0, count)
                .mapToObj(v -> LottoTicket.issue(lottoNumberRule.make()))
                .collect(Collectors.toList());
    }

    public int totalPrize(Map<Integer, Integer> matchTicketCounts) {
        int totalPrize = 0;
        for(Map.Entry<Integer, Integer> entry : matchTicketCounts.entrySet()) {
            totalPrize += (WinningPrize.getPrizeBy(entry.getKey()) * entry.getValue());
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
