package step2.lotto.view;

import java.util.Arrays;
import step2.lotto.domain.LottoPurchaseInfo;
import step2.lotto.domain.LottoRank;
import step2.lotto.domain.LottoScore;
import step2.lotto.domain.Lottos;

public class ResultView {

    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨통계";
    private static final String DEFAULT_CONTOUR = "--------------------------";
    private static final String LOTTO_RESULT_SCORE = "%d개 일치 (%d)원 - %d개";
    private static final String LOTTO_RESULT_PROFIT_RATIO = "총 수익률은 %.2f 입니다.";

    public void printPurchase(final LottoPurchaseInfo purchaseInfo) {
        System.out.printf(PURCHASE_RESULT_MESSAGE, purchaseInfo.getLottoTicketCount());
    }

    public void printPurchaseLottoTicketNumbers(final Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void printResultStatics(final LottoScore lottoScore, final LottoPurchaseInfo lottoPurchaseInfo) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DEFAULT_CONTOUR);

        Arrays.stream(LottoRank.values())
            .forEach(lottoRank -> System.out.println(printLottoScoreResult(lottoRank, lottoScore)));

        System.out.println(printLottoProfitRatio(lottoScore, lottoPurchaseInfo));
    }

    private String printLottoScoreResult(final LottoRank lottoRank, final LottoScore lottoScore) {
        return String.format(LOTTO_RESULT_SCORE, lottoRank.getMatchNumber(),
            lottoRank.getPrizeAmount(), lottoScore.getLottoScore().get(lottoRank));
    }

    private String printLottoProfitRatio(final LottoScore lottoScore, final LottoPurchaseInfo lottoPurchaseInfo) {
        return String.format(LOTTO_RESULT_PROFIT_RATIO, lottoScore.calculateProfitRatio(lottoPurchaseInfo));
    }

}
