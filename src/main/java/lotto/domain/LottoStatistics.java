package lotto.domain;

import java.util.List;

public class LottoStatistics {

    private final WinningLotto winningLotto;
    private final WinningCountMap winningCountMap;

    public LottoStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.winningCountMap = new WinningCountMap();

        analyzeLottosData(lottos);
    }

    public List<WinningLottoDto> getStatisticsData() {
        return winningCountMap.getDataSets();
    }

    public double getEarningsRate(int totalLottoSize) {
        return winningCountMap.getTotalPrize() / (double) (totalLottoSize * Money.LOTTO_PRICE);
    }

    private void analyzeLottosData(List<Lotto> lottos) {
        lottos.forEach(lotto -> winningCountMap.addCount(winningLotto.getWinningType(lotto)));
    }
}
