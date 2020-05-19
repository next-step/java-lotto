package lotto.view;

import lotto.domain.LottoMatch;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;

public final class ResultView {

    private static final double BASE_RATE = 1.0;
    private static final String NEW_LINE = "\n";

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

        StringBuilder builder = getResultMatchInfo(lottoMatchResult);
        System.out.println(builder.append(getResultMessage(lottoMatchResult.getProfitRate())));
    }

    private static void printResultTitle() {
        System.out.println(NEW_LINE + "당첨 통계" + NEW_LINE + "---------");
    }

    private static StringBuilder getResultMatchInfo(LottoMatchResult lottoMatchResult) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(LottoMatch.values())
                .forEach(lottoMatch -> {
                    String matchInfoMessage = getMatchInfoMessage(lottoMatch, lottoMatchResult.getMatchCount(lottoMatch));
                    builder.append(matchInfoMessage).append(NEW_LINE);
                });

        return builder;
    }

    private static String getMatchInfoMessage(LottoMatch lottoMatch, int matchCount) {
        return String.format("%d개 일치 (%d원)- %d개",
                lottoMatch.getCount(),
                lottoMatch.getAmount(),
                matchCount);
    }

    private static String getResultMessage(double profitRate) {
        return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                profitRate,
                getProfitOrLoss(profitRate));
    }

    private static String getProfitOrLoss(double profitRate) {
        return profitRate >= BASE_RATE ? "이익" : "손해";
    }
}
