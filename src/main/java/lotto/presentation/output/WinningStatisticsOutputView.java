package lotto.presentation.output;

import lotto.common.MatchHits;

public class WinningStatisticsOutputView {
    private static final String WINNING_STATISTICS_OUTPUT_COMMENT = "당첨 통계\n---------";
    private static final String THREE_MATCHES_COMMENT = "3개 일치 (5000원)- %d개%n";
    private static final String FOUR_MATCHES_COMMENT = "4개 일치 (50000원)- %d개%n";
    private static final String FIVE_MATCHES_COMMENT = "5개 일치 (1500000원)- %d개%n";
    private static final String SIX_MATCHES_COMMENT = "6개 일치 (2000000000원)- %d개%n";

    public void output(MatchHits matchHits) {
        System.out.println(WINNING_STATISTICS_OUTPUT_COMMENT);
        System.out.printf(THREE_MATCHES_COMMENT, matchHits.getThreeMatchHits());
        System.out.printf(FOUR_MATCHES_COMMENT, matchHits.getFourMatchHits());
        System.out.printf(FIVE_MATCHES_COMMENT, matchHits.getFiveMatchHits());
        System.out.printf(SIX_MATCHES_COMMENT, matchHits.getSixMatchHits());
    }
}
