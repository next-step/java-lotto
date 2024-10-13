package lotto.io;

import lotto.domain.result.LottoStatistics;
import lotto.domain.result.Rank;
import lotto.domain.ticket.LottoTickets;

import java.util.Map;

public class ConsoleOutputHandler implements OutputHandler {

    public static final String UNPROFITABLE = "손해";
    public static final String PROFITABLE = "이득";

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
        printMatchResults(lottoStatistics.getResults());
        printAssessmentText(getAssessmentText(lottoStatistics.getProfitRatio()));
    }

    private void printStatisticsTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printMatchResults(Map<Rank, Integer> results) {
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            printExceptRankNone(rank, count);
        }
    }

    private void printExceptRankNone(Rank rank, Integer count) {
        if (rank != Rank.NONE) {
            String row = rank.getResultForRow(count);
            System.out.println(row);
        }
    }

    private void printAssessmentText(String assessmentText) {
        System.out.println(assessmentText);
    }

    public String getAssessmentText(double floorProfitRatio) {
        return String.format("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                floorProfitRatio,
                isLessThanOne(floorProfitRatio) ? UNPROFITABLE : PROFITABLE);
    }

    private boolean isLessThanOne(double floorProfitRatio) {
        return floorProfitRatio < 1;
    }

}
