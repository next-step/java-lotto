package step3.winning;

import step3.lotto.Lotto;
import step3.lotto.LottoCount;
import step3.lotto.LottoNumber;
import step3.lotto.LottoTicket;

import java.math.*;
import java.util.*;

public class WinningStatistics {
    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private static final int FIVE_VALUE = 5;

    private final Map<WinningPrize, Integer> winningResults;
    private BigDecimal yield;

    public WinningStatistics(Lotto lottoList, WinningNumbers winningNumbers, LottoCount lottoCount, LottoNumber bonusNumber) {
        winningResults = new HashMap<>();
        this.yield = new BigDecimal(String.valueOf(0));
        calculateWinningResult(lottoList.getLottoTickets(), winningNumbers, bonusNumber);
        calculateYield(lottoCount.calculateCountToPrice());
    }

    public void calculateWinningResult(List<LottoTicket> lottoList, WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        for (int i = DEFAULT_VALUE; i < lottoList.size(); i++) {
            int points = compareNumbers(lottoList.get(i), winningNumbers);
            boolean hasBonusNumber = hasBonusNumber(points, lottoList.get(i), bonusNumber);
            WinningPrize prize = WinningPrize.valueOf(points, hasBonusNumber);
            winningResults.put(prize, hasWinningPrize(prize));
        }
    }

    public int compareNumbers(LottoTicket ticket, WinningNumbers winningNumbers) {
        int points = DEFAULT_VALUE;
        List<LottoNumber> winningNumberList = winningNumbers.getWinningNumbers();
        for (LottoNumber winningNumber: winningNumberList) {
            points += ticket.isContainNumber(winningNumber);
        }
        return points;
    }

    public boolean hasBonusNumber(int points, LottoTicket ticket, LottoNumber bonusNumber) {
        if (points == FIVE_VALUE && ticket.isContainNumber(bonusNumber) == ONE_VALUE) {
            return true;
        }
        return false;
    }

    private int hasWinningPrize(WinningPrize prize) {
       return this.winningResults.getOrDefault(prize, DEFAULT_VALUE) + ONE_VALUE;
    }

    public void calculateYield(final int amount) {
        BigDecimal totalPrizeMoney = new BigDecimal(String.valueOf(getTotalPrizeMoney()));
        this.yield = totalPrizeMoney.divide(new BigDecimal(String.valueOf(amount)), 2, RoundingMode.HALF_EVEN);
    }

    private int getTotalPrizeMoney() {
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
