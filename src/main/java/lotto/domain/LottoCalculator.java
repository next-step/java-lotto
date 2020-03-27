package lotto.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class LottoCalculator {
    private static final int RANK1_REWARD = 2000000000;
    private static final int RANK2_REWARD = 1500000;
    private static final int RANK3_REWARD = 50000;
    private static final int RANK4_REWARD = 5000;

    @Getter
    private int rank1Count;
    @Getter
    private int rank2Count;
    @Getter
    private int rank3Count;
    @Getter
    private int rank4Count;

    public LottoCalculator(List<Integer> lastWeekLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int sameCount = lotto.getSameCount(lastWeekLotto);

            if (sameCount == 3) {
                rank4Count++;
                continue;
            }

            if (sameCount == 4) {
                rank3Count++;
                continue;
            }

            if (sameCount == 5) {
                rank2Count++;
                continue;
            }

            if (sameCount >= 5) {
                rank1Count++;
                continue;
            }
        }
    }

    public BigDecimal getWinningPercentage(int investment) {
        int totalReward = (rank1Count * RANK1_REWARD) +
                (rank2Count * RANK2_REWARD) +
                (rank3Count * RANK3_REWARD) +
                (rank4Count * RANK4_REWARD);

        return new BigDecimal(totalReward).divide(new BigDecimal(investment), new MathContext(2, RoundingMode.DOWN));
    }
}
