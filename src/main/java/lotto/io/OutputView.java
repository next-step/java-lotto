package lotto.io;

import lotto.domain.LottoPrize;

public class OutputView {

    public static void print(Message message) {
        System.out.println(message.message);
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printLottoPrize(LottoPrize prize) {
        print(prize.matchCount + "개 일치(" + prize.matchPrize + ")- " + prize.getWinningCount() + "개");
    }

    public static void printProfitRate(Double profitRate) {
        print("총 수익률은 " + profitRate + "입니다.");
    }
}