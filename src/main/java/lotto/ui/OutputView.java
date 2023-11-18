package lotto.ui;

import lotto.ui.dto.LottoStatsResponse;
import lotto.ui.dto.MyLottosResponse;

public class OutputView {
    public static void outputPurchaseCount(int purchaseCount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void outputMyLottos(MyLottosResponse myLottosResponse) {
        myLottosResponse.getLottos()
                .forEach((lottoResponse) -> System.out.println(lottoResponse.getNums()));
    }

    public static void outputLottoStats(LottoStatsResponse lottoStatsResponse) {
        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoStatsResponse.getLottoStats().forEach(
                lottoStatResponse -> {
                    System.out.printf("%d개 일치 (%d원)- %d개\n"
                            , lottoStatResponse.getMatchCount()
                            , lottoStatResponse.getReceiveMoney()
                            , lottoStatResponse.getMatchCountResult());
                }
        );
        System.out.printf("총 수익률은 %.2f입니다.", lottoStatsResponse.getProfitRate());
    }
}
