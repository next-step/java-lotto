package lotto.io;

import lotto.domain.number.LottoNumber;
import lotto.domain.result.LottoStatistics;
import lotto.domain.result.Rank;
import lotto.domain.ticket.LottoTicket;
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
    public void showNumberOfTicketsBought(int manualLottoPurchaseCount, int autoLottoPurchaseCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoPurchaseCount, autoLottoPurchaseCount);
    }

    @Override
    public void showLottoTickets(LottoTickets lottoTickets) {
        System.out.println(generateLottoTicketsText(lottoTickets));
    }

    public String generateLottoTicketsText(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            sb.append(generateLottoNumbersText(lottoTicket)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private String generateLottoNumbersText(LottoTicket lottoTicket) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            builder.append(lottoNumber.toString()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
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

    @Override
    public void showBonusBallText() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    @Override
    public void showCommentForManualLottoPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    @Override
    public void showCommentForManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
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
            String row = getResultForRow(rank, count);
            System.out.println(row);
        }
    }

    private String getResultForRow(Rank rank, int matchedLottoCount) {
        if (rank.isSecond()) {
            return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개", rank.getMatchCount(), rank.getPrizeAmount(), matchedLottoCount);
        }
        return String.format("%s개 일치 (%s원)- %s개", rank.getMatchCount(), rank.getPrizeAmount(), matchedLottoCount);
    }

    private void printAssessmentText(String assessmentText) {
        System.out.println(assessmentText);
    }

    public String getAssessmentText(double floorProfitRatio) {
        return String.format("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", floorProfitRatio, getAssessmentWord(floorProfitRatio));
    }

    public String getAssessmentWord(double floorProfitRatio) {
        if (isLessThanOne(floorProfitRatio)) {
            return UNPROFITABLE;
        }
        return PROFITABLE;
    }

    private boolean isLessThanOne(double floorProfitRatio) {
        return floorProfitRatio < 1;
    }

}
