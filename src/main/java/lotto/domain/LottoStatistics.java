package lotto.domain;

import java.util.List;

public class LottoStatistics {

    private static final int LOTTO_PRICE = 1000;

    private final Lotto winningLotto;
    private final WinningCountMap winningCountMap;

    public LottoStatistics(Lotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.winningCountMap = new WinningCountMap();

        analyzeLottosData(lottos);
    }

    public List<WinningLottoDto> getStatisticsData() {
        return winningCountMap.getDataSets();
    }

    public double getEarningsRate(int totalLottoSize) {
        return winningCountMap.getTotalPrize() / (double) (totalLottoSize * LOTTO_PRICE);
    }

    private void analyzeLottosData(List<Lotto> lottos) {
        lottos.forEach(lotto -> winningCountMap.addCount(winningLotto.getWinningType(lotto)));
    }
}
