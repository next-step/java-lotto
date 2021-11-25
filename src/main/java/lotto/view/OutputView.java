package lotto.view;

import lotto.domain.LottoGameCount;
import lotto.domain.Lottoes;
import lotto.utils.RankEnum;

import static lotto.utils.Constants.*;

public class OutputView {
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

        System.out.println(getRankMsg(NUMBER_THREE.longValue(), lottoes));
        System.out.println(getRankMsg(NUMBER_FOUR.longValue(), lottoes));
        System.out.println(getRankMsg(NUMBER_FIVE.longValue(), lottoes));
        System.out.println(getRankMsg(NUMBER_SIX.longValue(), lottoes));
    }

    public StringBuilder getRankMsg(Long rank, Lottoes lottoes) {
        RankEnum rankEnum = RankEnum.findBy(rank);
        StringBuilder sb = new StringBuilder();
        sb.append(rankEnum.getMsg());
        sb.append(lottoes.winRankLottoCount(rank));
        sb.append(MSG_NUMBER);
        return sb;
    }

    public void drawTotalReward(Double yield) {
        StringBuilder sb = new StringBuilder();
        sb.append(MSG_TOTAL_YIELD);
        sb.append(yield);
        sb.append(MSG_IS);
        System.out.println(sb);
    }
}
