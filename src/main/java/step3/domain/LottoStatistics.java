package step3.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoStatistics {

    private static final List<Integer> LOTTO_WINNING_COUNTS = Arrays.asList(3, 4, 5, 6);

    private final Lotto winningLotto;
    private final WinningCountMap winningCountMap;

    public LottoStatistics(Lotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.winningCountMap = new WinningCountMap();

        analyzeLottosData(lottos);
    }

    public List<LottoWinningData> getStatistics() {
        return LOTTO_WINNING_COUNTS.stream()
                                   .map(winningCountMap::toDataSet)
                                   .collect(toList());
    }

    public double getEarningsRate(int totalLottoPrice) {
        return winningCountMap.getTotalResult() / (double) totalLottoPrice;
    }

    private void analyzeLottosData(List<Lotto> lottos) {
        lottos.forEach(lotto -> winningCountMap.addCount(winningLotto.getMatchCount(lotto)));
    }
}
