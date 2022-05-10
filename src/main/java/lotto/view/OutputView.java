package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.RankResults;

import java.util.List;

public class OutputView {

    public static final String INPUT_MANUAL_LOTTO_TICKET_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n--------";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 ";
    private static final String GAIN_RESULT_MESSAGE = "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String DAMAGE_RESULT_MESSAGE = "입니다.(기준이 1이기 대문에 결과적으로 손해라는 의미임)";
    private static final String PRINT_RATIO_FORMAT = "%.2f";
    public static final String TICKET_COUNT_MESSAGE_FORMAT = "수동으로 %d개, 자동으로 %d개 구매하였습니다.\n";

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        printLottoNumbers(lottoTickets);
    }

    private void printLottoNumbers(List<LottoTicket> lottoTickets) {
        StringBuilder builder = new StringBuilder();
        lottoTickets.forEach(lottoTicket ->
                builder.append(lottoTicket.getLottoNumbers()).append("\n"));
        System.out.println(builder);
    }

    public void printResult(RankResults rankResults, Money money) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        printPrize(rankResults);
        printProfitRatio(rankResults.getProfitRatio(money));
    }

    private void printProfitRatio(double profitRatio) {
        String ratioString = this.getRatioString(profitRatio);
        System.out.println(ratioString);
    }

    private String getRatioString(double profitRatio) {
        StringBuilder builder = new StringBuilder();
        builder.append(TOTAL_RATE_OF_RETURN_MESSAGE);
        String ratioString = getFormat(profitRatio);
        builder.append(ratioString);
        if (profitRatio > 1) {
            builder.append(GAIN_RESULT_MESSAGE);
            return builder.toString();
        }
        builder.append(DAMAGE_RESULT_MESSAGE);

        return builder.toString();
    }

    private String getFormat(double profitRatio) {
        return String.format(PRINT_RATIO_FORMAT, profitRatio);
    }

    public void printPrize(RankResults rankResults) {
        String resultString = this.getResultString(rankResults.getRankResultList());
        System.out.println(resultString);
    }

    private String getResultString(List<RankResult> rankResults) {
        StringBuilder builder = new StringBuilder();
        rankResults.forEach(r -> {
                    builder.append(r.getMatchNumberCount());
                    builder.append("개 일치 ");
                    builder.append(r.getPrizePerRank());
                    builder.append("원 - ");
                    builder.append(r.getCount());
                    builder.append("개");
                    builder.append("\n");
                });
        return builder.toString();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printManualTicketNumberMessage() {
        System.out.println(INPUT_MANUAL_LOTTO_TICKET_NUMBERS_MESSAGE);
    }

    public void printTicketCount(int manualTicketsSize, int randomTicketsSize) {
        System.out.printf(TICKET_COUNT_MESSAGE_FORMAT, manualTicketsSize, randomTicketsSize);
    }
}
