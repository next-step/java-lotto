package lotto.domain.rank;

import lotto.domain.PositiveNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRanks {
    private static final int EMPTY_COUNT = 0;
    private final Map<LottoRank, Integer> countOfLottoRank;

    public LottoRanks(Map<LottoRank, Integer> countOfLottoRank) {
        this.countOfLottoRank = new HashMap<>(countOfLottoRank);
    }

    public static LottoRanks createByList(List<LottoRank> lottoRanks) {
        final int PER_COUNT_INCREMENT = 1;

        Map<LottoRank, Integer> countOfLottoRank = new HashMap<>();

        for (LottoRank lottoRank : lottoRanks) {
            int count = EMPTY_COUNT;
            if (countOfLottoRank.containsKey(lottoRank)) {
                count = countOfLottoRank.get(lottoRank);
            }

            countOfLottoRank.put(lottoRank, count + PER_COUNT_INCREMENT);
        }

        return new LottoRanks(countOfLottoRank);
    }

    public PositiveNumber sumReward() {
        PositiveNumber sumRewardOfRanks = PositiveNumber.ZERO;
        for (LottoRank lottoRank : LottoRank.values()) {
            sumRewardOfRanks = sumRewardOfRanks.plus(sumOfRank(lottoRank));
        }

        return sumRewardOfRanks;
    }

    private PositiveNumber sumOfRank(LottoRank rank) {
        return new PositiveNumber(countOf(rank) * rank.getAmount());
    }

    public Integer countOf(LottoRank lottoRank) {
        if (countOfLottoRank.containsKey(lottoRank)) {
            return countOfLottoRank.get(lottoRank);
        }

        return EMPTY_COUNT;
    }
}
