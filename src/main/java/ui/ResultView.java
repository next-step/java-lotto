package ui;

import model.LottoResult;
import model.Rank;

public class ResultView {
    public static void getResult(int payAmount, LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + result.getRankCount(Rank.FOUR));
        System.out.println("4개 일치 (50000원) - " + result.getRankCount(Rank.THIRD));
        System.out.println("5개 일치 (1500000원) - " + result.getRankCount(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원) - " + result.getRankCount(Rank.FIRST));

        System.out.println("총 수익률은 " + String.format("%.2f", (double) result.getTotalPrice() / payAmount) + "% 입니다.");
    }
}
