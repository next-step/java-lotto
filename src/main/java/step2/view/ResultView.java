package step2.view;

import step2.model.*;

import java.text.MessageFormat;

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
                    .append(getLottoRankFormat(lottoRank))
                    .append(TICKET_INDICATOR)
                    .append(matchCount)
                    .append(TICKET_UNIT)
                    .append(LINE_FEED);
        });

        System.out.println(stringBuilder.toString());
    }

    private static String getLottoRankFormat(LottoRank lottoRank) {
        if (lottoRank.isBonusRequired()) {
            return MessageFormat.format("{0}개 일치, 보너스 볼 일치 ({1}원)",
                    lottoRank.getCountOfMatch(), lottoRank.getWinningMoney());
        }

        return MessageFormat.format("{0}개 일치 ({1}원)",
                lottoRank.getCountOfMatch(), lottoRank.getWinningMoney());
    }

    public static void printMatchReport(MatchReport matchReport) {
        System.out.println("총 수익률은 " + matchReport.calculateEarningRate() + "입니다.");
    }
}
