package step5.winning;

import step5.lotto.LottoTicket;
import java.math.*;
import java.util.*;

public class WinningStatistics {
    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private static final int FIVE_VALUE = 5;

    private final Map<WinningPrize, Integer> winningResults;
    private BigDecimal yield;

    public WinningStatistics() {
        winningResults = new HashMap<>();
        this.yield = new BigDecimal(String.valueOf(DEFAULT_VALUE));
    }

    public void calculateWinningResult(List<LottoTicket> lottoList, WinningNumbers winningNumbers) {
        for (int i = DEFAULT_VALUE; i < lottoList.size(); i++) {
            WinningPrize prize = makeWinningResult(lottoList.get(i), winningNumbers);
            winningResults.put(prize, getWinningPrizeCount(prize));
        }
    }

    public WinningPrize makeWinningResult(LottoTicket ticket, WinningNumbers winningNumbers) {
        int points = winningNumbers.calculateWinningPoints(ticket);
        boolean bonusNumberResult = false;
        if (points == FIVE_VALUE) {
            bonusNumberResult = winningNumbers.hasBonusNumber(ticket);
        }
        return  WinningPrize.valueOf(points, bonusNumberResult);
    }

    private int getWinningPrizeCount(WinningPrize prize) {
        return this.winningResults.getOrDefault(prize, DEFAULT_VALUE) + ONE_VALUE;
    }

    public void calculateYield(final int amount) {
        BigDecimal totalPrizeMoney = new BigDecimal(String.valueOf(sumTotalPrizeMoney()));
        this.yield = totalPrizeMoney.divide(new BigDecimal(String.valueOf(amount)), 2, RoundingMode.HALF_EVEN);
    }

    private int sumTotalPrizeMoney() {
        int totalPrizeMoney = DEFAULT_VALUE;
        for (WinningPrize winningPrize : winningResults.keySet()) {
            totalPrizeMoney += winningPrize.getWinningMoney() * winningResults.get(winningPrize);
        }
        return totalPrizeMoney;
    }

    public Map<WinningPrize, Integer> getWinningResults() {
        return Collections.unmodifiableMap(winningResults);
    }

    public BigDecimal getYield() {
        return this.yield;
    }
}