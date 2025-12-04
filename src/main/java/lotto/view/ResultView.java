package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;

public class ResultView {
    public static void printLottos(LottoGame lottoGame) {
        System.out.println(lottoGame.lottoCount() + "개를 구매했습니다.");
        System.out.println(lottoGame);
    }

    public static void printResult(LottoResult result, Money money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.println(rank.match() + "개 일치, 보너스 볼 일치 (" + rank.prize() + "원) - " + result.getCount(rank) + "개");
                continue;
            }
            System.out.println(rank.match() + "개 일치 (" + rank.prize() + "원) - " + result.getCount(rank) + "개");
        }
        printRateOfReturn(result, money);

    }

    private static void printRateOfReturn(LottoResult result, Money money) {
        double rate = result.profitRate(money);
        String message = String.format("총 수익률은 %.2f입니다.", rate);
        if (rate < 1.0) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.println(message);
    }


}
