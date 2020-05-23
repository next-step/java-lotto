package lotto.view;

import lotto.domain.LottoMatch;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoNumbers;

import java.util.List;

public final class ResultView {

    private static final String NEW_LINE = System.lineSeparator();

    private ResultView() {
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        StringBuilder builder = new StringBuilder();
        lottoNumbers.forEach(lotto -> builder.append(lotto).append(NEW_LINE));

        System.out.println(builder);
    }

    public static void printMatchResult(LottoMatchResult lottoMatchResult) {
        printResultTitle();

        System.out.println(getResultMatchInfo(lottoMatchResult));
    }

    private static void printResultTitle() {
        System.out.println(NEW_LINE + "당첨 통계" + NEW_LINE + "---------");
    }

    private static StringBuilder getResultMatchInfo(LottoMatchResult lottoMatchResult) {
        StringBuilder builder = new StringBuilder();
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            String matchInfoMessage = getMatchInfoMessage(lottoMatch, lottoMatchResult.getMatchCount(lottoMatch));
            builder.append(matchInfoMessage).append(NEW_LINE);
        }

        return builder;
    }

    private static String getMatchInfoMessage(LottoMatch lottoMatch, int matchCount) {
        return String.format("%d개 일치%s(%d원)- %d개",
                lottoMatch.getCount(),
                lottoMatch.getBonusContext(),
                lottoMatch.getAmount(),
                matchCount);
    }

    public static void printProfitRate(double profitRate, String result) {
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                profitRate,
                result));
    }
}
