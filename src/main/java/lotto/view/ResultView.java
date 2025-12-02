package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoResult result, LottoGame lottoGame) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.println(rank.match() + "개 일치, 보너스 볼 일치 (" + rank.prize() + "원) - " + result.getCount(rank) + "개");
            }
            System.out.println(rank.match() + "개 일치 (" + rank.prize() + "원) - " + result.getCount(rank) + "개");
        }
        printRateOfReturn(result, lottoGame);

    }

    private static void printRateOfReturn(LottoResult result, LottoGame lottoGame) {
        double rate = lottoGame.rateOfReturn(result);
        String message = String.format("총 수익률은 %.2f입니다.", rate);
        if (rate < 1.0) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.println(message);
    }


}
