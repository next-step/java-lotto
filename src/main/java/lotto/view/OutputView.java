package lotto.view;

import lotto.domain.LottoGameCount;
import lotto.domain.Lottoes;

import static lotto.utils.Constants.*;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    private OutputView() {

    }

    public static void drawLottoGameCount(LottoGameCount lottoGameCount) {
        System.out.println(lottoGameCount.getLottoGameCount() + MSG_LOTTO_COUNT);
    }

    public static void drawPurchasedLottoes(Lottoes lottoes) {
        lottoes.getLottoGames().forEach(lottoGame ->
                System.out.println(lottoGame.getLottoNumbers().getLottoNumbers()));
        System.out.println();
    }

    public static void drawResultWinLotto(Lottoes lottoes) {
        System.out.println(MSG_WINNING_STATISTICS);
        System.out.println(MSG_DASH_TEN);

        getRankMsg((long) NUMBER_THREE, lottoes);
        getRankMsg((long) NUMBER_FOUR, lottoes);
        getRankMsg((long) NUMBER_FIVE, lottoes);
        getRankMsg((long) NUMBER_SIX, lottoes);
    }

    public static void getRankMsg(Long rank, Lottoes lottoes) {
//        RankEnum rankEnum = RankEnum.valueOf(rank);
//        sb.append(rankEnum.getMsg());
        sb.append(lottoes.winRankLottoCount(rank));
        sb.append(MSG_NUMBER);
        System.out.println(sb);
        sb.setLength(NUMBER_ZERO);
    }

    public static void drawTotalReward(Double yield) {
        sb.append(MSG_TOTAL_YIELD);
        sb.append(yield);
        sb.append(MSG_IS);
        System.out.println(sb);
    }
}
