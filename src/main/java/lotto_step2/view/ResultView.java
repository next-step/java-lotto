package lotto_step2.view;

import lotto_step2.model.Prize;

import java.util.List;

import static lotto_step2.LottoConstants.*;

public class ResultView {

    private int prizeFourth;
    private int prizeThird;
    private int prizeSecond;
    private int prizeFirst;

    public void printGameResult (List<Prize> gameResults) {
        calcGameResult(gameResults);

        System.out.println("\n당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + this.prizeFourth + "개");
        System.out.println("4개 일치 (50000원)- " + this.prizeThird + "개");
        System.out.println("5개 일치 (1500000원)- " + this.prizeSecond + "개");
        System.out.println("6개 일치 (2000000000원)- " + this.prizeFirst + "개");
    }

    private void calcGameResult(List<Prize> gameResults) {
        this.prizeFourth = (int) gameResults.stream()
                .filter(result -> result.getPrize().getMatchCount() == MATCH_PRIZE_FOURTH)
                .count();

        this.prizeThird = (int) gameResults.stream()
                .filter(result -> result.getPrize().getMatchCount() == MATCH_PRIZE_THIRD)
                .count();

        this.prizeSecond = (int) gameResults.stream()
                .filter(result -> result.getPrize().getMatchCount() == MATCH_PRIZE_SECOND)
                .count();

        this.prizeFirst = (int) gameResults.stream()
                .filter(result -> result.getPrize().getMatchCount() == MATCH_PRIZE_FIRST)
                .count();
    }

    public void printRevenue(List<Prize> gameResults, int money) {
        float rate = calcRevenue(gameResults, money);

        System.out.print(String.format("총 수익률은 %.2f 입니다. ", rate));
        if(rate < 1) {
            System.out.println("(기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)");
        }
    }

    private float calcRevenue(List<Prize> gameResults, int money) {
        int totalPrize = 0;

        for (Prize result : gameResults) {
            totalPrize += result.getPrize().getLottoPrize();
        }
        return (float) totalPrize / money;
    }
}
