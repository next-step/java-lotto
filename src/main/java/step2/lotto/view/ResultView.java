package step2.lotto.view;

import java.util.Arrays;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.domain.LottoRank;
import step2.lotto.domain.LottoScore;
import step2.lotto.domain.LottoTicketCount;
import step2.lotto.domain.Lottos;

public class ResultView {

    private static final String PURCHASE_RESULT_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨통계";
    private static final String DEFAULT_CONTOUR = "--------------------------";
    private static final String LOTTO_RESULT_SCORE = "%d개 일치 (%d)원 - %d개";
    private static final String LOTTO_RESULT_SCORE_BONUS = "%d개 일치, 보너스볼 일치 (%d)원 - %d개";
    private static final String LOTTO_RESULT_PROFIT_RATIO = "총 수익률은 %.2f 입니다.";

    public void printPurchase(final LottoTicketCount lottoTicketCount) {
        System.out.printf(PURCHASE_RESULT_MESSAGE,
            lottoTicketCount.getManualLottoTicketCount(), lottoTicketCount.getRandomLottoTicketCount());
    }

    public void printPurchaseLottoTicketNumbers(final Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void printResultStatics(final LottoScore lottoScore, final LottoPurchase lottoPurchase) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DEFAULT_CONTOUR);

        Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank != LottoRank.LOSE)
            .forEach(lottoRank -> System.out.println(printLottoScoreResult(lottoRank, lottoScore)));

        System.out.println(printLottoProfitRatio(lottoScore, lottoPurchase));
    }

    private String printLottoScoreResult(final LottoRank lottoRank, final LottoScore lottoScore) {
        if (lottoRank == LottoRank.SECOND) {
            return String.format(LOTTO_RESULT_SCORE_BONUS, lottoRank.getCountOfMatch(),
                lottoRank.getPrizeAmount(), lottoScore.getLottoScore().get(lottoRank));
        }
        return String.format(LOTTO_RESULT_SCORE, lottoRank.getCountOfMatch(),
            lottoRank.getPrizeAmount(), lottoScore.getLottoScore().get(lottoRank));
    }

    private String printLottoProfitRatio(final LottoScore lottoScore,
        final LottoPurchase lottoPurchase) {
        return String.format(LOTTO_RESULT_PROFIT_RATIO, lottoScore.calculateProfitRatio(
            lottoPurchase));
    }

}
