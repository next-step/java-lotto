package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        Map<LottoPrize, Integer> lottoPrizes = result.getLottoPrizes();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<LottoPrize, Integer> entry : lottoPrizes.entrySet()) {
            LottoPrize lottoPrize = entry.getKey();
            int lottoPrizeCount = entry.getValue();
            if (lottoPrize == LottoPrize.MISS) {
                continue;
            }
            if (lottoPrize == LottoPrize.SECOND) {
                System.out.println(lottoPrize.getMatchCount() + "개 일치, 보너스 볼 일치 (" + lottoPrize.getWinningMoney() + "원)- " + lottoPrizeCount + "개");
                continue;
            }
            System.out.println(lottoPrize.getMatchCount() + "개 일치 (" + lottoPrize.getWinningMoney() + "원)- " + lottoPrizeCount + "개");
        }
        System.out.printf("총 수익률은 %,.2f입니다.%n", result.getRate());
    }
}
