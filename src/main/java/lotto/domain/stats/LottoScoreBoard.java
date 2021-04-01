package lotto.domain.stats;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.prize.Prize;

public class LottoScoreBoard {
    private final PrizeBoard prizeBoard;
    private final List<Lotto> candidateLottoList;
    private final WinningLotto winningLotto;

    public LottoScoreBoard(List<Lotto> candidateLottoList, WinningLotto winningLotto) {
        prizeBoard = new PrizeBoard();
        this.winningLotto = winningLotto;
        this.candidateLottoList = candidateLottoList;
    }

    public void scoring() {
        for (Lotto lotto : candidateLottoList) {
            long scoreTotal = winningLotto.getScoreIfMatchingBall(lotto) +
                    winningLotto.getScoreIfMatchingBonusBall(lotto);

            prizeBoard.record(Prize.getPrizeByScore(scoreTotal));
        }
    }

    public long getWinnerCountByPrize(Prize prize) {
        return prizeBoard.getWinnerCountByPrize(prize);
    }
}
