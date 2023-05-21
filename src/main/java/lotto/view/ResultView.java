package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String SHOW_PURCHASE_COUNT_RESULT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String NINE_DASH = "---------";
    private static final String RESULT_MENT = "%s개 일치 (%s원) - %s개";
    private static final String RESULT_MENT_FOR_SECOND_PLACE = "%s개 일치, 보너스 볼 일치(%s원) - %s개";
    private static final String RATE_OF_RETURN_MENT = "총 수익률은 %.2f입니다.";

    public void showPurchaseCount(int manuallyPurchaseCount, int automaticallyPurchaseCount) {
        System.out.println(formatShowPurchaseCountResult(manuallyPurchaseCount, automaticallyPurchaseCount));
    }

    public void showLottos(List<Lotto> createdLottos) {
        createdLottos.forEach(ResultView::showLotto);
        System.out.println();
    }

    private static void showLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        System.out.println(numbers);
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

    private String formatShowPurchaseCountResult(int manuallyPurchaseCount, int automaticallyPurchaseCount) {
        return String.format(SHOW_PURCHASE_COUNT_RESULT, manuallyPurchaseCount, automaticallyPurchaseCount);
    }

    private String formatRateOfReturnMent(LottoResult lottoResult) {
        return String.format(RATE_OF_RETURN_MENT, lottoResult.findRateOfReturn());
    }

    private String formatResultMent(Rank rank, LottoResult lottoResult) {
        if (rank.equals(Rank.SECOND_PLACE)) {
            return String.format(RESULT_MENT_FOR_SECOND_PLACE, rank.getWinningCount(), rank.getWinnings(), lottoResult.findWinningCount(rank));
        }
        return String.format(RESULT_MENT, rank.getWinningCount(), rank.getWinnings(), lottoResult.findWinningCount(rank));
    }
}

