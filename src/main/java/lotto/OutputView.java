package lotto;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    public static void outputCnt(int lottoCnt) {
        System.out.println(lottoCnt + "개 구매하셨습니다.");
    }

    public static void outputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void winningNumberPrint(LottoResult lottoResult, int amount) {
        System.out.println("당첨통계");
        Map<Integer, List<Integer>> summary = lottoResult.resultSummary();
        Set<Integer> keys = summary.keySet();
        for (int key : keys) {
            System.out.print(key + "개 일치");
            System.out.print("(" + lottoResult.PRIZE_MONEY.get(key) + ")");
            System.out.println(" : " + summary.get(key).size() + "개");
        }
        System.out.println("총 수익률은 " + lottoResult.rateOfReturnAll()+ "입니다.");
        System.out.println("총 수익률은 " + lottoResult.rateOfReturnAll() / amount * 100 + "입니다.");
    }
}
