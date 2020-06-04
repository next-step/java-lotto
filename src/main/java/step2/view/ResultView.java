package step2.view;

import step2.model.LottoTicket;
import step2.model.LottoTickets;
import step2.model.MatchReport;
import step2.model.MatchResult;

public class ResultView {

    private static final String LINE_FEED = System.lineSeparator();

    private static final String TICKET_INDICATOR = " - ";
    private static final String TICKET_UNIT = "개";

    private ResultView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(lottoTickets.getTicketCount())
                .append("장을 구매했습니다.")
                .append(LINE_FEED);

        lottoTickets.getLottoTickets().stream()
                .map(LottoTicket::toString)
                .forEach(s -> stringBuilder.append(s).append(LINE_FEED));

        System.out.println(stringBuilder.toString());
    }

    public static void printMatchResult(MatchResult matchResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계").append(LINE_FEED);
        stringBuilder.append("---------").append(LINE_FEED);

        matchResult.getWinningResult().forEach((lottoRank, matchCount) -> {
            stringBuilder
                    .append(lottoRank.toString())
                    .append(TICKET_INDICATOR)
                    .append(matchCount)
                    .append(TICKET_UNIT)
                    .append(LINE_FEED);
        });

        System.out.println(stringBuilder.toString());
    }

    public static void printMatchReport(MatchReport matchReport) {
        System.out.println("총 수익률은 " + matchReport.calculateEarningRate() + "입니다.");
    }
}
