package view;

import domain.Rank;
import domain.RankAmount;

import java.util.Arrays;
import java.util.List;

import static domain.Rank.*;

public class OutputView {

    public static void printResultNotice() {
        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printRankAmount(RankAmount rankLongMap) {
        List<Rank> ranks = Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
        for (Rank rank : ranks) {
            System.out.println(String.format("%d개 일치 (%d원) - %d개",rank.getMatchCount(), rank.getRewardMoney(), rankLongMap.getAmount(rank)));
        }
    }

    public static void printResultYield(float a) {
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", a));
    }

}
