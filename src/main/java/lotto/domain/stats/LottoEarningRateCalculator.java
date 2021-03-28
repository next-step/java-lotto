package lotto.domain.stats;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;

public class LottoEarningRateCalculator {
    private final long principal; // 원금
    private final Lotto winnerLotto;
    private final List<Lotto> winnerCandidates;

    public LottoEarningRateCalculator(Lotto winnerLotto, List<Lotto> winnerCandidates) {
        principal = winnerCandidates.size() * LottoShop.LOTTO_PRICE;
        this.winnerLotto = winnerLotto;
        this.winnerCandidates = winnerCandidates;
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
        for (Lotto lotto : winnerCandidates) {
            long equalNumberCount = winnerLotto.getEqualNumberCountFrom(lotto);
            prizeTotal += Prize.getPrizeByEqualNumberCount(equalNumberCount);
        }
        return prizeTotal / (double) principal;
    }
}
