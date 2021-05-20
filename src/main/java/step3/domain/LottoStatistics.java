package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoStatistics {

    private final Lotto winningLotto;
    private final WinningCountMap winningCountMap;

    public LottoStatistics(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.winningCountMap = new WinningCountMap();
    }

    public void analyzeLottosData(List<Lotto> lottos) {
        lottos.forEach(lotto -> winningCountMap.addCount(winningLotto.getMatchCount(lotto)));
    }

    public List<String> getStatistics() {
        return Stream.iterate(3, i -> i + 1)
                     .limit(4)
                     .map(winningCountMap::toStringOf)
                     .collect(toList());
    }

    public double getEarningsRate(int totalLottoPrice) {
        return winningCountMap.getTotalResult() / (double) totalLottoPrice;
    }
}
