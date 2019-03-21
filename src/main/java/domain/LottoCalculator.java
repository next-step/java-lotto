package domain;

import application.LottoGameResult;

import java.text.DecimalFormat;
import java.util.List;

public class LottoCalculator implements Calculator {
    private static final int LOTTO_MATCH_MIN_COUNT = 3;
    private static final int LOTTO_SIZE = 6;

    public double result(List<Integer> lottoGameResults, int price) {
        return format(divide(sum(lottoGameResults), price));
    }

    private static int sum(List<Integer> lottoGameResults) {
        int profit = 0;
        for (int i = LOTTO_MATCH_MIN_COUNT; i < LOTTO_SIZE; i++) {
            profit += multiple(i, lottoGameResults.get(i));
        }

        return profit;
    }

    private static double format(double number) {
        return Double.valueOf(new DecimalFormat("#.##").format(number));
    }

    private static double divide(int profit, int price) {
        return (profit / (double) price);
    }

    private static int multiple(int number, int count) {
        return LottoGameResult.calculate(number, count);
    }
}
