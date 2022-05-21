package lotto.view;

import lotto.model.Lottery;

import java.util.List;

public class ResultView {
    public static void printLotteries(List<Lottery> lotteries, String payload) {
        System.out.printf("%d %s lotteries are purchased.\n", lotteries.size(), payload);
        for (Lottery lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public static void printWinStatistics(String payload) {
        System.out.println("Win Statistics");
        System.out.println("------------------");
        System.out.println(payload);
    }

    public static void print(String payload) {
        System.out.println(payload);
    }


    public static void printEarned(double profitRate) {
        String payload = evaluateRate(profitRate);
        print(payload);
    }

    public static String evaluateRate(double profitRate) {
        if (profitRate >= 1) {
            return "📈Earned!";
        }
        return "📉Lost..";
    }
}
