package lotto.domain;

import java.util.List;

public class LottoResult {
    private Lottos lottos;
    private LottoCount lottoCount;
    private StringBuilder lottosView;

    public LottoResult(Lottos lottos, LottoCount lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public void reportLottos() {
        lottosView = new StringBuilder();
        lottosView.append(lottoCount.message());
        lottosView.append(lottos.message());
    }

    public StringBuilder getLottosView() {
        return lottosView;
    }

    public StringBuilder getStatisticsView(List<Integer> matchCounts) {
        LottoStatistic lottoStatistic = new LottoStatistic(matchCounts, lottoCount);
        return lottoStatistic.message();
    }
}
