package step2.view;

import step2.domain.LottoMachine;
import step2.domain.LottoNumbers;
import step2.domain.LottoRank;
import step2.domain.LottoWinningRecord;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void showPurchasedLottos(List<LottoNumbers> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        lottoNumbers.forEach(number -> System.out.println(number.numbers()));
    }

    public static void showLottoWinningResult(LottoWinningRecord record, int purchasedLottoCount) {
        System.out.println("\n당첨 통계\n---------");
        Map<LottoRank, Integer> rankMap = record.rankMap();
        rankMap.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.NO_MATCH)
                .forEach(entry ->
                        System.out.printf("%s - %d개%n", entry.getKey().description(), entry.getValue()));

        double ratio = record.totalLottoPrizeRatio(purchasedLottoCount * LottoMachine.PRICE_OF_LOTTO);
        System.out.printf("총 수익률은 %.2f입니다.", ratio);
        if (ratio < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
