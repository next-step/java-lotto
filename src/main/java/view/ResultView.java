package view;

import domain.*;

import java.util.Map;

public class ResultView {
    public static void printNumberOfLottos(int turn, int manual) {
        System.out.println();
        System.out.println("수동으로 " + manual + "장, 자동으로 " + (turn - manual) + "개를 구매했습니다.");
    }

    public static void printLottos(LottoCreate lottos) {
        for(Lotto lotto : lottos.getLottocreate()) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void printResult(LottoResult list) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000)원 - " + list.getCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " + list.getCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " + list.getCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + list.getCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + list.getCount(Rank.FIRST) + "개");
    }

    public static void printProfit(LottoResult lottoResult, int totalMoney) {
        int sum = 0;
        for(Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            Rank rank = entry.getKey();
            Integer integer = entry.getValue();
            sum += Money.sum(rank, integer);
        }
        System.out.println();
        System.out.println("총 수익률은 " + Money.profitRatio(totalMoney, sum) + "입니다.");
    }
}