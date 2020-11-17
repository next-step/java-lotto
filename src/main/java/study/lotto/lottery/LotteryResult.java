package study.lotto.lottery;

import study.lotto.core.Lotto;
import study.lotto.core.LottoRank;

import java.util.*;
import java.util.Map.Entry;

public class LotteryResult {

    private final Map<LottoRank, Integer> reduceByLottoRank;
    private final double totalReturnRatio;

    public LotteryResult(Map<LottoRank, List<Lotto>> groupByLottoRank, double totalReturnRatio) {
        this.reduceByLottoRank = reduceByLottoRank(groupByLottoRank);
        this.totalReturnRatio = totalReturnRatio;
    }

    private Map<LottoRank, Integer> reduceByLottoRank(Map<LottoRank, List<Lotto>> groupByLottoRank) {
        Map<LottoRank, Integer> reduceByLottoRank = new HashMap<>();
        for (Entry<LottoRank, List<Lotto>> entry : groupByLottoRank.entrySet()) {
            reduceByLottoRank.put(entry.getKey(), entry.getValue().size());
        }
        return reduceByLottoRank;
    }

    public Map<LottoRank, Integer> reduceByLottoRank() {
        return reduceByLottoRank;
    }

    public double getTotalReturnRatio() {
        return totalReturnRatio;
    }

    public Integer getNumberOfLottoRank(LottoRank lottoRank) {
        Integer numerOfLottoRank = reduceByLottoRank.get(lottoRank);
        return Objects.nonNull(numerOfLottoRank) ? numerOfLottoRank : 0;
    }

}
