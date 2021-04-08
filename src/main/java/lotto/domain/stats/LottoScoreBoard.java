package lotto.domain.stats;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;

public class LottoScoreBoard {
    private final PrizeBoard prizeBoard;

    private LottoScoreBoard() {
        prizeBoard = new PrizeBoard();
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

    public List<Score> getScoreResult() {
        return prizeBoard.getScoreResult();
    }

    public static LottoScoreBoard create(LottoOrderedList lottoOrderedList, WinningLotto winningLotto) {
        LottoScoreBoard lottoScoreBoard = new LottoScoreBoard();
        for (Lotto lotto : lottoOrderedList.getLottoList()) {
            lottoScoreBoard.prizeBoard.record(
                    Prize.getPrizeByScore(winningLotto.getScoreIfMatchingBall(lotto)));
        }
        return lottoScoreBoard;
    }

}
