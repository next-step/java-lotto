package step2.view;

import step2.LotteryAwardSystem;

import java.util.Scanner;

public class ResultView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printResult(LotteryAwardSystem lotteryAwardSystem) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = 3; i < 7; i++) {
            System.out.println(i + "개 일치 (" + lotteryAwardSystem.getPrizeMap().get(i) + ") - " + lotteryAwardSystem.getWinnersCountMap().getOrDefault(i, 0) + "개");
        }
        System.out.println("총 수익률은 " + lotteryAwardSystem.getProfitRate() + "입니다.");
    }
}
