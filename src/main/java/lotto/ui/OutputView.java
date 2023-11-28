package lotto.ui;

import lotto.domain.LottoPrize;
import lotto.ui.dto.LottoStatResponse;
import lotto.ui.dto.LottoStatsResponse;
import lotto.ui.dto.MyLottosResponse;

import java.util.stream.Stream;

public class OutputView {
    public static void outputPurchaseCount(int manualLottoCount, int purchaseCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount, purchaseCount);
    }

    public static void outputMyLottos(MyLottosResponse myLottosResponse) {
        myLottosResponse.getLottos()
                .forEach((lottoResponse) -> System.out.println(lottoResponse.getNums()));
    }

    public static void outputLottoStats(LottoStatsResponse lottoStatsResponse) {
        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");
        Stream.of(LottoPrize.values()).forEach(
                (lottoPrize) -> outputLottoStatResponse(lottoPrize, lottoStatsResponse.getLottoStats().get(lottoPrize)));
        System.out.printf("총 수익률은 %.2f입니다.", lottoStatsResponse.getProfitRate());
    }

    private static void outputLottoStatResponse(LottoPrize lottoPrize, LottoStatResponse lottoStatResponse) {
        if (lottoPrize.equals(LottoPrize.SECOND)) {
            secondLottoStatResponse(lottoStatResponse);
            return;
        }
        defaultLottoStatResponse(lottoStatResponse);
    }


    private static void secondLottoStatResponse(LottoStatResponse lottoStatResponse) {
        System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개\n"
                , lottoStatResponse.getMatchCount()
                , lottoStatResponse.getReceiveMoney()
                , lottoStatResponse.getMatchCountResult());
    }

    private static void defaultLottoStatResponse(LottoStatResponse lottoStatResponse) {
        System.out.printf("%d개 일치 (%d원)- %d개\n"
                , lottoStatResponse.getMatchCount()
                , lottoStatResponse.getReceiveMoney()
                , lottoStatResponse.getMatchCountResult());
    }
}
