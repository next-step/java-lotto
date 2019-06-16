package view;

import vo.MatchingResult;
import vo.MatchingResults;

public class ResultView {
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
        sb.append("%입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

        System.out.println(sb.toString());
    }

    private static void appendByMatch(StringBuilder sb, MatchingResult matchingResult) {
        sb.append(matchingResult.getDisplayText());
        sb.append(" - ");
        sb.append(matchingResult.getCountOfMatchingLotto());
        sb.append("개");
        sb.append(NEWLINE);
    }

    public void printPurchaseTicketCount(int count) {
        System.out.println(String.format("%s개를 구매했습니다.", count));
    }
}
