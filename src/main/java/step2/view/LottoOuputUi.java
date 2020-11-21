package step2.view;

import step2.constant.LottoWinningPrizes;
import step2.domain.Lotto;

import java.util.EnumMap;
import java.util.List;

public class LottoOuputUi {

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getLottos)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoCount(int lottoPurchaseQty) {
        System.out.println(lottoPurchaseQty + "개를 구매했습니다.");
    }

    public static void printStatistics(EnumMap<LottoWinningPrizes, Integer> lottoWinningPrizesMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinningStatistics(lottoWinningPrizesMap);
    }

    private static void printWinningStatistics(EnumMap<LottoWinningPrizes, Integer> lottoWinningPrizesMap) {
        lottoWinningPrizesMap.forEach((key, value) ->
                System.out.println(key.getMatch() + "개 일치 (" + key.getAmount() + "원) - " + value + "개"));
    }

    public static void printTotalReturn(double yield) {
        System.out.println("총 수익률은" + yield + "입니다");
    }
}
