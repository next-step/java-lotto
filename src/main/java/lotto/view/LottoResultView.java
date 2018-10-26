package lotto.view;

import lotto.domain.MatchingResult;
import lotto.domain.MatchingResults;

public class LottoResultView {
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String LOTTO_REPORT_HEADER = "당첨 통계" + NEWLINE + "----" + NEWLINE;
    
    public static void show(MatchingResults result) {
        StringBuilder sb = new StringBuilder(LOTTO_REPORT_HEADER);
        
        Iterable<MatchingResult> matchingResults = result.getResults();
        for (MatchingResult matchingResult : matchingResults) {
            appendByMatch(sb, matchingResult);
        }
        sb.append("총 수익률은 ");
        sb.append(result.getProfit());
        sb.append("%입니다.");

        System.out.println(sb.toString());
    }

    private static void appendByMatch(StringBuilder sb, MatchingResult matchingResult) {
        sb.append(matchingResult.getDisplayText());
        sb.append(" - ");
        sb.append(matchingResult.getCountOfMatchingLotto());
        sb.append("개");
        sb.append(NEWLINE);
    }
}
