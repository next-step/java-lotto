package lotto.view;

import lotto.domain.LottoGameCount;
import lotto.domain.Lottoes;
import lotto.utils.RankEnum;

import static lotto.utils.Constants.*;

public class OutputView {
    private StringBuilder sb;

    public OutputView() {
        sb = new StringBuilder();
    }

    public void drawLottoGameCount(LottoGameCount lottoGameCount) {
        System.out.println(lottoGameCount.getLottoGameCount() + MSG_LOTTO_COUNT);
    }

    public void drawPurchasedLottoes(Lottoes lottoes) {
        lottoes.getLottoGames().forEach(lottoGame ->
                System.out.println(lottoGame.getLottoNumbers().getLottoNumbers()));
        System.out.println();
    }

    public void drawResultWinLotto(Lottoes lottoes) {
        System.out.println(MSG_WINNING_STATISTICS);
        System.out.println(MSG_DASH_TEN);

        System.out.println(getRankMsg((long) NUMBER_THREE, lottoes));
        System.out.println(getRankMsg((long) NUMBER_FOUR, lottoes));
        System.out.println(getRankMsg((long) NUMBER_FIVE, lottoes));
        System.out.println(getRankMsg((long) NUMBER_SIX, lottoes));
    }

    public StringBuilder getRankMsg(Long rank, Lottoes lottoes) {
        RankEnum rankEnum = RankEnum.findBy(rank);
        sb.append(rankEnum.getMsg());
        sb.append(lottoes.winRankLottoCount(rank));
        sb.append(MSG_NUMBER);
        return sb;
    }

    public void drawTotalReward(Double yield) {
        sb.append(MSG_TOTAL_YIELD);
        sb.append(yield);
        sb.append(MSG_IS);
        System.out.println(sb);
    }
}
