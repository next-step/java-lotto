package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningRecord;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void showPurchasedLottos(List<LottoNumber> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        lottoNumbers.forEach(
                number -> {
                    System.out.println( number.numbers() );
                }
        );
    }

    public static void showLottoWinningResult(LottoWinningRecord record, int purchasedLottosCount) {
        showTitle();
        showWinningRecord(record);
        showTotalLottoPrizeRatio(record, purchasedLottosCount);
    }
    private static void showTitle() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    private static void showWinningRecord(LottoWinningRecord record) {
        Map<LottoRank, Integer> rank = record.lottoRankMap();
        rank.entrySet()
                .forEach(entry ->
                        System.out.printf("%s - %d개%n", entry.getKey().description(), entry.getValue())
                );
    }

    private static void showTotalLottoPrizeRatio(LottoWinningRecord record, int purchasedLottosCount) {
        float ratio = record.totalLottoPrizeAmount() / (purchasedLottosCount * LottoMachine.PRICE_OF_LOTTO);
        System.out.printf("총 수익률은 %.2f입니다.", ratio);
        if ( ratio < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
