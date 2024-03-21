package step2.view;

import step2.LotteryAwardSystem;
import step2.PrizeLevel;

import java.util.Scanner;

public class ResultView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printResult(LotteryAwardSystem lotteryAwardSystem) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (PrizeLevel level : PrizeLevel.values()) {
            System.out.println(level.getMatchCount() + "개 일치 " +
                    (level == PrizeLevel.SECOND ? "(보너스번호 일치) " : "") +
                    "(" + level.getPrizeAmount() + ") - " +
                    lotteryAwardSystem.getWinnersCountMap().getOrDefault(level, 0) + "개");
        }
        System.out.println("총 수익률은 " + lotteryAwardSystem.getProfitRate() + "입니다.");
    }
}
