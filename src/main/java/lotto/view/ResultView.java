package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String SHOW_PURCHASE_COUNT_RESULT = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String NINE_DASH = "---------";
    private static final String RESULT_MENT = "%s개 일치 (%s원) - %s개";
    private static final String RATE_OF_RETURN_MENT = "총 수익률은 %.2f입니다.";

    public void showPurchaseCount(int purchaseCount) {
        System.out.println(formatShowPurchaseCountResult(purchaseCount));
    }

    public void showLottos(List<Lotto> createdLottos) {
        createdLottos.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
        System.out.println();
    }

    public void showResults(LottoResult lottoResult) {
        showIntroBeforeResults();
        showMatchResults(lottoResult);
        showRateOfReturn(lottoResult);
    }

    private void showRateOfReturn(LottoResult lottoResult) {
        System.out.printf(formatRateOfReturnMent(lottoResult));
    }

    private void showIntroBeforeResults() {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(NINE_DASH);
    }

    private void showMatchResults(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.LOST))
                .map(rank -> formatResultMent(rank, lottoResult))
                .forEach(System.out::println);
    }

    private String formatShowPurchaseCountResult(int purchaseCount) {
        return String.format(SHOW_PURCHASE_COUNT_RESULT, purchaseCount);
    }

    private String formatRateOfReturnMent(LottoResult lottoResult) {
        return String.format(RATE_OF_RETURN_MENT, lottoResult.findRateOfReturn());
    }

    private String formatResultMent(Rank rank, LottoResult lottoResult) {
        return String.format(RESULT_MENT, rank.getWinningCount(), rank.getWinnings(), lottoResult.findWinningCount(rank));
    }
}

