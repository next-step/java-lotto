package lotto.io;

import lotto.domain.result.LottoStatistics;
import lotto.domain.result.Rank;
import lotto.domain.ticket.LottoTickets;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showCommentForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void showNumberOfTicketsBought(int availableLottoTickets) {
        System.out.printf("%s개를 구매했습니다.\n", availableLottoTickets);
    }

    @Override
    public void showLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    @Override
    public void showWinningNumbersText() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    @Override
    public void showLottoStatistics(LottoStatistics lottoStatistics) {
        printStatisticsTitle();
        printMatchResults(lottoStatistics);
        printProfitRatio(lottoStatistics);
    }

    private void printStatisticsTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printMatchResults(LottoStatistics lottoStatistics) {
        Map<Rank, Integer> results = lottoStatistics.getResults();
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            printExceptRankNone(rank, count);
        }
    }

    private void printProfitRatio(LottoStatistics lottoStatistics) {
        BigDecimal profitRatio = BigDecimal.valueOf(lottoStatistics.getProfitRatio());
        BigDecimal truncatedProfitRatio = profitRatio.setScale(2, RoundingMode.DOWN);
        System.out.printf(
                "총 수익률은 %s입니다.%s",
                truncatedProfitRatio.toPlainString(),
                isLessThanOne(truncatedProfitRatio) ?
                        "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""
        );
    }

    private boolean isLessThanOne(BigDecimal truncatedProfitRatio) {
        return truncatedProfitRatio.compareTo(BigDecimal.ONE) < 0;
    }

    private void printExceptRankNone(Rank rank, Integer count) {
        if (rank != Rank.NONE) {
            String row = rank.getResultForRow(count);
            System.out.println(row);
        }
    }
}
