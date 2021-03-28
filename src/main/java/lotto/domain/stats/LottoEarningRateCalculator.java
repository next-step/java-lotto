package lotto.domain.stats;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;

public class LottoEarningRateCalculator {
    private final long principal; // 원금
    private final LottoScoreBoard lottoScoreBoard;

    public LottoEarningRateCalculator(Lotto winnerLotto, List<Lotto> winnerCandidates) {
        principal = winnerCandidates.size() * LottoShop.LOTTO_PRICE;
        this.lottoScoreBoard = new LottoScoreBoard(winnerLotto, winnerCandidates);
    }

    public String resultToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        return decimalFormat.format(eval());
    }

    private double eval() {
        if (principal <= 0) {
            return 0;
        }

        long prizeTotal = 0L;
        lottoScoreBoard.scoring();

        for (Prize prize : Prize.values()) {
            Long winnings = lottoScoreBoard.getWinningsByEqualNumberCount(prize.getEqualNumberCount());
            prizeTotal += prize.getPrizeAmount() * winnings;
        }
        return prizeTotal / (double) principal;
    }
}
