package lotto;

import java.util.List;

public class ResultView {
    public static void printCount(int count) {
        System.out.println(count + "개를 구입하였습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(lottoResult.toStringRankResult(rank));
        }
        double profitRate = lottoResult.profitRate();
        System.out.println("총 수익률은 " + profitRate + "입니다.");
        if (profitRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
