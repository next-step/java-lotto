package lotto.domain.stats;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.prize.Prize;

public class LottoScoreBoard {
    private final PrizeBoard prizeBoard;
    private final LottoOrderedList lottoOrderedList;
    private final WinningLotto winningLotto;

    public LottoScoreBoard(LottoOrderedList lottoOrderedList, WinningLotto winningLotto) {
        prizeBoard = new PrizeBoard();
        this.winningLotto = winningLotto;
        this.lottoOrderedList = lottoOrderedList;
    }

    public void scoring() {
        for (Lotto lotto : lottoOrderedList.getLottoList()) {
            prizeBoard.record(Prize.getPrizeByScore(
                    winningLotto.getScoreIfMatchingBall(lotto)));
        }
    }

    public long getWinnerCountByPrize(Prize prize) {
        return prizeBoard.getWinnerCountByPrize(prize);
    }

    public long getLottoOrderedCount() {
        return this.lottoOrderedList.getLottoOrderedCount();
    }
}
