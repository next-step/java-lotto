package lotto.domain.stats;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;

public class LottoScoreBoard {
    private final PrizeBoard prizeBoard;

    public LottoScoreBoard(LottoOrderedList lottoOrderedList, WinningLotto winningLotto) {
        prizeBoard = new PrizeBoard();
        for (Lotto lotto : lottoOrderedList.getLottoList()) {
            prizeBoard.record(Prize.getPrizeByScore(winningLotto.getScoreIfMatchingBall(lotto)));
        }
    }

    public String getEarningRate() {
        long principal = prizeBoard.getWinnerCountWithNothingPrizeTotal() * LottoShop.LOTTO_PRICE;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        return decimalFormat.format(prizeBoard.getWinnersPrizeAmountTotal() / (double) principal);
    }

    public long getWinnerCountByPrize(Prize prize) {
        return prizeBoard.getWinnerCountByPrize(prize);
    }

}
