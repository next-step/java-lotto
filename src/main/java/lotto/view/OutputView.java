package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatisticsResult;
import lotto.utils.LottoUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ", ";

    private OutputView() {}

    public static void printPurchasedLottos(List<Lotto> manualLottos, List<Lotto> randomLottos) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다." + NEW_LINE, manualLottos.size(), randomLottos.size());
        List<Lotto> allLottos = LottoUtils.mergeTwoLottoLists(manualLottos, randomLottos);
        for (Lotto lotto : allLottos) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            System.out.printf("[%s]" + NEW_LINE, lottoNumbers.stream()
                            .map(LottoNumber::toString)
                    .collect(Collectors.joining(DELIMITER)));
        }
        System.out.println();
    }

    public static void printResult(LottoStatisticsResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        LottoRank.getRewardRanksReversed()
                .forEach(rank -> System.out.println(getStringFormat(rank, result.getCountByRank(rank))));
        System.out.printf("총 수익률은 %.2f입니다.", result.getProfit());
    }

    private static String getStringFormat(LottoRank rank, int numberOfRank) {
        if (rank.hasBonusNumber()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)- %d개", rank.getMatchCount(), rank.getReward(), numberOfRank);
        }
        return String.format("%d개 일치 (%s원)- %d개", rank.getMatchCount(), rank.getReward(), numberOfRank);
    }

}
