package edu.nextstep.lottocustom.domain;

import java.util.Arrays;
import java.util.Map;

public class WinningResult {

    private final Map<Prize, Integer> winningResult;
    private final double rateOfReturn;

    public WinningResult(Map<Prize, Integer> winningResult, int totalPayment) {
        this.winningResult = winningResult;
        this.rateOfReturn = calculateRateOfReturn(winningResult, totalPayment);
    }

    private double calculateRateOfReturn(Map<Prize, Integer> winningResult, int totalPayment) {
        long totalWinningPrize = calculateWinningPrize(winningResult);

        return (double) totalWinningPrize / totalPayment;
    }

    private long calculateWinningPrize(Map<Prize, Integer> winningResult) {
        return Arrays.stream(Prize.values())
                .mapToLong(prize -> prize.calculatePrize(winningResult.get(prize)))
                .sum();
    }

    public int get(Prize prize) {
        return winningResult.get(prize);
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

}
