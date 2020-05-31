package me.daeho.lotto.domain;

import java.math.BigDecimal;
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

    public int totalPrize(Map<Rank, Integer> matchTicketCounts) {
        int totalPrize = 0;
        for(Map.Entry<Rank, Integer> entry : matchTicketCounts.entrySet()) {
            totalPrize += (entry.getKey().getPrize() * entry.getValue());
        }
        return totalPrize;
    }

    public Map<Rank, Integer> matchTicketCounts(List<LottoNumber> lastWinningNumber, LottoNumber bonusBall, List<LottoTicket> tickets) {
        final Map<Rank, Integer> rankCounts = new HashMap<>();
        tickets.forEach(t -> {
            int matchCount = t.containsCount(lastWinningNumber);
            Rank winningPrize = Rank.valueOf(matchCount, isMatchBonusBall(bonusBall, t));
            rankCounts.put(
                    winningPrize,
                    increaseMatchTicketCount(rankCounts, winningPrize)
            );
        });
        return rankCounts;
    }

    private boolean isMatchBonusBall(LottoNumber bonusBall, LottoTicket t) {
        return t.containsCount(bonusBall) == 1;
    }

    private int increaseMatchTicketCount(Map<Rank, Integer> matchNumbers, Rank winningPrize) {
        return matchNumbers.getOrDefault(winningPrize, 0) + 1;
    }

    public double earningRate(int amount, int totalPrize) {
        return BigDecimal.valueOf(totalPrize)
                .divide(BigDecimal.valueOf(amount), 2, BigDecimal.ROUND_UP)
                .doubleValue();
    }
}
