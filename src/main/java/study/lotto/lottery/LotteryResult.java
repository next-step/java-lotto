package study.lotto.lottery;

import study.lotto.core.Lotto;
import study.lotto.core.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LotteryResult {

    private final Map<LottoRank, List<Lotto>> groupByLottoRank;
    private final double totalReturnRatio;

    public LotteryResult(Map<LottoRank, List<Lotto>> groupByLottoRank, double totalReturnRatio) {
        this.groupByLottoRank = groupByLottoRank;
        this.totalReturnRatio = totalReturnRatio;
    }

    public Map<LottoRank, List<Lotto>> getGroupByLottoRank() {
        return groupByLottoRank;
    }

    public double getTotalReturnRatio() {
        return totalReturnRatio;
    }

    public List<Lotto> getLottoRankOf(LottoRank lottoRank) {

        List<Lotto> lottos = groupByLottoRank.get(lottoRank);

        if (Objects.isNull(lottos)) {
            return new ArrayList<>();
        }

        return lottos;
    }
}
