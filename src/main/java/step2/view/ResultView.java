package step2.view;

import step2.model.*;

import java.text.MessageFormat;
import java.util.Comparator;

public class ResultView {

    private static final String LINE_FEED = System.lineSeparator();

    private static final String TICKET_INDICATOR = " - ";
    private static final String TICKET_UNIT = "개";

    private ResultView() {
    }

    public static void printTickets(LottoTicket lottoTicket) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(lottoTicket.getLottoCount())
                .append("장을 구매했습니다.")
                .append(LINE_FEED);

        lottoTicket.getLottos().stream()
                .map(Lotto::toString)
                .forEach(s -> stringBuilder.append(s).append(LINE_FEED));

        System.out.println(stringBuilder.toString());
    }

    public static void printMatchResult(MatchResult matchResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계").append(LINE_FEED);
        stringBuilder.append("---------").append(LINE_FEED);

        LottoRank.WINNING_RANKS.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(lottoRank -> {
                    int matchCount = matchResult.findResult(lottoRank);

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
        System.out.println(MessageFormat.format("총 수익률은 {0}입니다.", matchReport.calculateEarningRate()));
    }
}
