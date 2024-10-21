package lotto.view;

import lotto.application.LottoWinningStatistics;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoRank;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    public static void printLottoQuantityPurchased(int manualLottoQuantity, int lottoQuantityWithoutManual) {
        if (manualLottoQuantity == 0) {
            System.out.printf("자동으로 %d장을 구매했습니다.%s", lottoQuantityWithoutManual, NEW_LINE);
            return;
        }
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%s", manualLottoQuantity, lottoQuantityWithoutManual, NEW_LINE);
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        lottos.forEach(lottoNumbers -> stringBuilder.append(lottoNumbers.values()).append(NEW_LINE));
        System.out.println(stringBuilder);
    }

    public static void printWinningStatistics(LottoPrice lottoTicketPurchaseAmount, LottoWinningStatistics winningStatistics) {
        printWinningCount(winningStatistics);
        printReturnRate(lottoTicketPurchaseAmount, winningStatistics);
    }

    private static void printReturnRate(LottoPrice lottoPurchaseAmount, LottoWinningStatistics winningStatistics) {
        float returnRate = winningStatistics.calculateReturnRate(lottoPurchaseAmount);

        System.out.printf("총 수익률은 %.2f입니다.", returnRate);
        if (returnRate < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static void printWinningCount(LottoWinningStatistics winningStatistics) {
        StringBuilder stringBuilder = new StringBuilder("당첨 통계").append(NEW_LINE).append("---------").append(NEW_LINE);

        for (LottoRank ranking : LottoRank.winningRanks()) {
            stringBuilder
                    .append(OutputView.winningRankDescription(ranking))
                    .append(String.format(" (%d원)- %d개", ranking.getDistributionRatioPrice(), winningStatistics.getLottoQuantityOfRanking(ranking)))
                    .append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static String winningRankDescription(LottoRank winningRank) {
        if (LottoRank.SECOND.equals(winningRank)) {
            return String.format("%d개 일치, 보너스 볼 일치", winningRank.getWinningRankMatchingCount());
        }
        return String.format("%d개 일치", winningRank.getWinningRankMatchingCount());
    }

}
