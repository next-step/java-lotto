package lotto.presentation.output;

import lotto.common.MatchCount;

public class WinningStatisticsOutputView {
    private static final String WINNING_STATISTICS_OUTPUT_COMMENT = "당첨 통계\n---------";

    public void output(MatchCount matchCount) {
        System.out.println(WINNING_STATISTICS_OUTPUT_COMMENT);
        System.out.printf("3개 일치 (5000원)- %d개%n", matchCount.getThreeMatches());
        System.out.printf("4개 일치 (50000원)- %d개%n", matchCount.getFourMatches());
        System.out.printf("5개 일치 (1500000원)- %d개%n", matchCount.getFiveMatches());
        System.out.printf("6개 일치 (2000000000원)- %d개%n", matchCount.getSixMatches());
    }
}
