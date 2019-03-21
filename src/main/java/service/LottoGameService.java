package service;

import application.LottoGameResult;

import java.text.DecimalFormat;
import java.util.List;

public class LottoGameService {
    private static final int LOTTO_MATCH_MIN_COUNT = 3;

    public static double calculate(List<Integer> lottoGameResults, int price) {
        int profit = 0;
        for (int i = 0; i < lottoGameResults.size(); i++) {
            profit += sum(lottoGameResults, i);
        }
        return format(divide(profit, price));
    }

    private static double format(double number) {
        return Double.valueOf(new DecimalFormat("#.##").format(number));
    }

    private static double divide(int result, int price) {
        return (result / (double) price);
    }

    private static int sum(List<Integer> results, int index) {
        return results.get(index) * LottoGameResult.match(index + LOTTO_MATCH_MIN_COUNT).getReward();
    }
}
