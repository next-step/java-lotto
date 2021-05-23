package step3.winning;

import step3.lotto.Lotto;
import step3.lotto.LottoCount;
import step3.lotto.LottoNumber;

import java.math.*;
import java.util.*;

public class WinningStatistics {
    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private final Map<WinningPrize, Integer> winningResults;
    private BigDecimal yield;

    public WinningStatistics(Lotto lottoList, WinningNumbers winningNumbers, LottoCount lottoCount) {
        winningResults = new HashMap<>();
        this.yield = new BigDecimal(String.valueOf(0));
        calculateWinningResult(lottoList, winningNumbers);
        calculateYield(lottoCount.calculateCountToPrice());
    }

    public void calculateWinningResult(Lotto lottoList, WinningNumbers winningNumbers) {
        for (int i = DEFAULT_VALUE; i < lottoList.size(); i++) {
            int points = compareNumbers(lottoList, winningNumbers, i);
            WinningPrize prize = WinningPrize.valueOf(points);
            winningResults.put(prize, hasWinningPrize(prize));
        }
    }

    private int compareNumbers(Lotto lottoList, WinningNumbers winningNumbers, int index) {
        int points = DEFAULT_VALUE;
        Iterator<LottoNumber> iterator = lottoList.iteratorLottoTicket(index);
        while (iterator.hasNext()) {
            points += winningNumbers.isContainNumber(iterator.next());
        }
        return points;
    }

    private int hasWinningPrize(WinningPrize prize) {
       return this.winningResults.getOrDefault(prize, DEFAULT_VALUE) + ONE_VALUE;
    }

    public void calculateYield(final int amount) {
        BigDecimal totalPrizeMoney = new BigDecimal(String.valueOf(getTotalPrizeMoney()));
        this.yield = totalPrizeMoney.divide(new BigDecimal(String.valueOf(amount)), 2, RoundingMode.HALF_EVEN);
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
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
