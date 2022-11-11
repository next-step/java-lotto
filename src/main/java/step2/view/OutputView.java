package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoRank;
import step2.domain.Lottos;
import step2.domain.PurchasePrice;

import java.util.List;

public class OutputView {

    private static final String LOTTO_COUNT_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_REWARD_PREFACE = "\n당첨 통계\n---------";
    private static final String WIN_NUMBER_MESSAGE_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String WIN_BONUS_NUMBER_MESSAGE_FORMAT = "%d개 보너스 볼 일치 (%d원) - %d개";
    private static final String YIELD_MESSAGE = "총 수익률은 %s 입니다. (기준 : 1)";

    private OutputView() {}

    public static void lottoPurchaseOutput(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + LOTTO_COUNT_OUTPUT_MESSAGE);
        lottoPurchaseDetailOutput(lottos);
    }

    public static void lottoRewardOutput(List<LottoRank> lottoRanks) {
        System.out.println(LOTTO_REWARD_PREFACE);
        System.out.println(getWinNumberFormat(lottoRanks));
    }

    private static void lottoPurchaseDetailOutput(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Lotto::getLotto)
                .forEach(System.out::println);
    }

    private static String getWinNumberFormat(List<LottoRank> lottoRanks) {
        String result = "";
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.WINNING_FIVE_BONUS_NUMBER) {
                result += String.format(WIN_BONUS_NUMBER_MESSAGE_FORMAT, lottoRank.getCountOfMatchNumber(), lottoRank.getReward(), lottoRank.getCountOfLottoRanks(lottoRanks)) + "\n";
            }
            if (lottoRank != LottoRank.MISS && lottoRank != LottoRank.WINNING_FIVE_BONUS_NUMBER) {
                result += String.format(WIN_NUMBER_MESSAGE_FORMAT, lottoRank.getCountOfMatchNumber(), lottoRank.getReward(), lottoRank.getCountOfLottoRanks(lottoRanks)) + "\n";
            }
        }
        return result;
    }

    public static void lottoYieldOutput(List<LottoRank> lottoRanks, PurchasePrice purchasePrice) {
        System.out.println(getYieldFormat(LottoRank.getYield(lottoRanks, purchasePrice)));
    }

    private static String getYieldFormat(double yield) {
        return String.format(YIELD_MESSAGE, yield);
    }
}
