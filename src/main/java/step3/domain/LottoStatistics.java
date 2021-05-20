package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private final Lotto winningLotto;
    private final WinningCountMap winningCountMap;

    public LottoStatistics(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.winningCountMap = new WinningCountMap();
    }

    public List<String> getStatistics(List<Lotto> lottos) {

        addLottoDataToMap(lottos);

        List<String> statistics = new ArrayList<>();
        statistics.add("당첨 통계");
        statistics.add("---------");

        for (int matchCount = 3; matchCount <= 6; matchCount++) {
            statistics.add(winningCountMap.toStringOf(matchCount));
        }

        statistics.add(getEarningsRate(lottos.size(), winningCountMap.getTotalResult()));

        return statistics;
    }

    private void addLottoDataToMap(List<Lotto> lottos) {
        lottos.forEach(lotto -> winningCountMap.addCount(winningLotto.getMatchCount(lotto)));
    }

    private String getEarningsRate(int lottoCount, long totalPrize) {
        double rate = totalPrize / (double) (lottoCount * 1000);
        return String.format("총 수익률은 %.2f입니다.", rate);
    }
}
