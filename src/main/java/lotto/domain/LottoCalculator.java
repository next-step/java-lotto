package lotto.domain;

import lombok.Getter;
import lotto.type.RankType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class LottoCalculator {
    @Getter
    private int rank1Count;
    @Getter
    private int rank2Count;
    @Getter
    private int rank3Count;
    @Getter
    private int rank4Count;

    public LottoCalculator(Lotto lastWeekLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            RankType rankType = RankType.getRank(lotto.getSameCount(lastWeekLotto));

            if (rankType == RankType.RANK1) {
                rank1Count++;
                continue;
            }

            if (rankType == RankType.RANK2) {
                rank2Count++;
                continue;
            }

            if (rankType == RankType.RANK3) {
                rank3Count++;
                continue;
            }

            if (rankType == RankType.RANK4) {
                rank4Count++;
                continue;
            }
        }
    }

    public BigDecimal getWinningPercentage(int investment) {
        int totalReward = RankType.RANK1.totalReward(rank1Count) +
                RankType.RANK2.totalReward(rank2Count) +
                RankType.RANK3.totalReward(rank3Count) +
                RankType.RANK4.totalReward(rank4Count);

        return new BigDecimal(totalReward).divide(new BigDecimal(investment), new MathContext(2, RoundingMode.DOWN));
    }
}
