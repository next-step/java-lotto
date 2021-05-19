package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRanks {
    private static final int EMPTY_COUNT = 0;
    private Map<LottoRank, Integer> countOfLottoRank;

    public LottoRanks(Map<LottoRank, Integer> countOfLottoRank) {
        this.countOfLottoRank = new HashMap<>(countOfLottoRank);
    }

    public static LottoRanks createByList(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> countOfLottoRank = new HashMap<>();

        for (LottoRank lottoRank : lottoRanks) {
            int count = 0;
            if(countOfLottoRank.containsKey(lottoRank)) {
                count = countOfLottoRank.get(lottoRank);
            }

            countOfLottoRank.put(lottoRank, count + 1);
        }

        return new LottoRanks(countOfLottoRank);
    }

    public Integer countOf(LottoRank lottoRank) {
        if(countOfLottoRank.containsKey(lottoRank)) {
            return countOfLottoRank.get(lottoRank);
        }

        return EMPTY_COUNT;
    }
}
