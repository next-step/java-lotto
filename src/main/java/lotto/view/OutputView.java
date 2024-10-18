package lotto.view;

import lotto.application.LottoWinningStatistics;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;

public class OutputView {
    private static final int LOTTO_PRICE_PER_ONE = 1000;
    private static final String NEW_LINE = System.lineSeparator();

    public static int printLottoTicketQuantityPurchased(int lottoPurchaseAmount) {
        int lottoCount = lottoPurchaseAmount / LOTTO_PRICE_PER_ONE;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public static void printLottos(List<Lotto> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        lottoTickets.forEach(lottoNumbers -> stringBuilder.append(lottoNumbers.values()).append(NEW_LINE));
        System.out.println(stringBuilder);
    }

    public static void printWinningStatistics(int lottoTicketPurchaseAmount, LottoWinningStatistics winningStatistics) {
        printWinningCount(winningStatistics);
        printReturnRate(lottoTicketPurchaseAmount, winningStatistics);
    }

    private static void printReturnRate(int lottoPurchaseAmount, LottoWinningStatistics winningStatistics) {
        int lottoWinningAmount = winningStatistics.calculateWinningAmount();
        float returnRate = LottoWinningStatistics.calculateReturnRate(lottoWinningAmount, lottoPurchaseAmount);

        System.out.printf("총 수익률은 %.2f입니다.", returnRate);
        if (returnRate < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static void printWinningCount(LottoWinningStatistics winningStatistics) {
        StringBuilder stringBuilder = new StringBuilder("당첨 통계").append(NEW_LINE).append("---------").append(NEW_LINE);

        for (LottoRank ranking : LottoRank.values()) {
            stringBuilder
                    .append(String.format("%d개 일치 (%d원)- %d개",
                            ranking.getMatchingCount(), ranking.getDistributionRatioPrice(), winningStatistics.getLottoQuantityOfRanking(ranking)))
                    .append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

}
