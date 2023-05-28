package lotto.view;

import lotto.Lotto;
import lotto.LottoPricePolicy;
import lotto.LottoStatics;
import lotto.Lottos;
import lotto.Number;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println("[" + lotto.getLottoNumbers()
                    .stream()
                    .map(Number::getNumberToString)
                    .collect(Collectors.joining(", ")) + "]");
        }
    }

    public static void printLottosCount(int lottoSize) {
        System.out.println(lottoSize + "개를 구매했습니다.");
    }

    public static void printLottosProfit(double ratio) {
        System.out.println("총 수익률은" + ratio + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void printStatics(LottoStatics lottoStatics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (" + LottoPricePolicy.FIFTH.getWinningAmount() + ")원 -" + lottoStatics.getNumberCount(LottoPricePolicy.FIFTH) + "개");
        System.out.println("4개 일치 (" + LottoPricePolicy.FOURTH.getWinningAmount() + ")원 -" + lottoStatics.getNumberCount(LottoPricePolicy.FOURTH) + "개");
        System.out.println("5개 일치 (" + LottoPricePolicy.THREE.getWinningAmount() + ")원 -" + lottoStatics.getNumberCount(LottoPricePolicy.THREE) + "개");
        System.out.println("5개 일치, 보너스 볼 일 (" + LottoPricePolicy.SECOND.getWinningAmount() + ")원 -" + lottoStatics.getNumberCount(LottoPricePolicy.SECOND) + "개");
        System.out.println("6개 일치 (" + LottoPricePolicy.FIRST.getWinningAmount() + ")원 -" + lottoStatics.getNumberCount(LottoPricePolicy.FIRST) + "개");
    }
}
