package lotto.domain;

import java.util.List;

public class Lotto {
    public static LottoStatistics createStatistics(List<Integer> equalNumberCountList) {
        LottoStatistics lottoStatistics = LottoStatistics.createEmpty();

        for (int equalNumberCount : equalNumberCountList) {
            LottoRank lottoRank = LottoRank.fromEqualNumberCount(equalNumberCount);
            lottoStatistics.plusCount(lottoRank);
        }

        return lottoStatistics;
    }
}
