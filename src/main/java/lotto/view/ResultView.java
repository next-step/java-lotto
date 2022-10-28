package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.LottoWinningType;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoAmountAndNumbers(final List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoWinningStatistics(final LottoWinningStatistics lottoWinningStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoWinningType, Integer> lottoWinningTypeCountMap = lottoWinningStatistics.getLottoWinningTypeCountMap();
        LottoWinningType.valuesByMatchNumbersCountAsc()
                        .stream()
                        .filter(lottoWinningType -> !LottoWinningType.NONE.equals(lottoWinningType))
                        .forEach(lottoWinningType -> System.out.printf("%d 개 일치 (%d 원)-%d 개%n",
                                lottoWinningType.getMatchNumbersCount(), lottoWinningType.getWinningAmount()
                                , lottoWinningTypeCountMap.getOrDefault(lottoWinningType, 0)));

        System.out.printf("총 수익률은 %.2f 입니다.", lottoWinningStatistics.getYield());

        if (lottoWinningStatistics.getYield() < 1) {
            System.out.print("(기준이 1 이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }
}
