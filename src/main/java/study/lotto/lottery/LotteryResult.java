package study.lotto.lottery;

import study.lotto.core.LottoRank;
import study.lotto.core.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryResult {

    private final Map<LottoRank, Long> countByLottoRank;
    private final double totalReturnRatio;

    public LotteryResult(List<WinningLotto> winningLottos, double totalReturnRatio) {
        this.countByLottoRank = countByLottoRank(winningLottos);
        this.totalReturnRatio = totalReturnRatio;
    }

    private Map<LottoRank, Long> countByLottoRank(List<WinningLotto> winningLottos) {
        return winningLottos.stream()
                .collect(Collectors.groupingBy(WinningLotto::getLottoRank, Collectors.counting()));
    }

    public Map<LottoRank, Long> getCountByLottoRank() {
        return countByLottoRank;
    }

    public double getTotalReturnRatio() {
        return totalReturnRatio;
    }

    public Long getNumberOfLottoRank(LottoRank lottoRank) {
        Long numerOfLottoRank = countByLottoRank.get(lottoRank);
        return Objects.nonNull(numerOfLottoRank) ? numerOfLottoRank : 0L;
    }

}
