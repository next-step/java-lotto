package ui;

import model.lotto.Lotto;
import model.lotto.LottoResult;
import model.lotto.Rank;

import java.util.List;

public class ResultView {
    public static void printLottoResults(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + result.getRankCount(Rank.FOURTH));
        System.out.println("4개 일치 (50000원) - " + result.getRankCount(Rank.THIRD));
        System.out.println("5개 일치 (1500000원) - " + result.getRankCount(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원) - " + result.getRankCount(Rank.FIRST));

        System.out.println("총 수익률은 " + String.format("%.2f", result.getTotalProfitPercent()) + "% 입니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos){
        for(Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
