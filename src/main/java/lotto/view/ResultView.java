package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {}

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult, double profitability) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<LottoRank, Integer> resultMap = lottoResult.getResultMap();
        System.out.println(LottoRank.FIFTH.getMatchCount() + "개 일치 (" + LottoRank.FIFTH.getWinningPrize() + "원)- " + resultMap.getOrDefault(LottoRank.FIFTH, 0) + "개");
        System.out.println(LottoRank.FOURTH.getMatchCount() + "개 일치 (" + LottoRank.FOURTH.getWinningPrize() + "원)- " + resultMap.getOrDefault(LottoRank.FOURTH, 0) + "개");
        System.out.println(LottoRank.THIRD.getMatchCount() + "개 일치 (" + LottoRank.THIRD.getWinningPrize() + "원)- " + resultMap.getOrDefault(LottoRank.THIRD, 0) + "개");
        System.out.println(LottoRank.SECOND.getMatchCount() + "개 일치, 보너스 볼 일치(" + LottoRank.SECOND.getWinningPrize() + "원)- " + resultMap.getOrDefault(LottoRank.SECOND, 0) + "개");
        System.out.println(LottoRank.FIRST.getMatchCount() + "개 일치 (" + LottoRank.FIRST.getWinningPrize() + "원)- " + resultMap.getOrDefault(LottoRank.FIRST, 0) + "개");

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(profitability);
        System.out.print("총 수익률은 " + formattedValue + "입니다.");
        System.out.printf("(기준이 1이기 때문에 결과적으로 %s라는 의미임)", determineMessage(profitability));
    }

    private static String determineMessage(double profitability) {
        return profitability > 1 ? "이익" : (profitability < 1 ? "손해" : "본전");
    }
}