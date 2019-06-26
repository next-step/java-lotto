package lotto.model;

public class LottoResultMatcher {

    private Lottos lottos;

    public LottoResultMatcher(Lottos lottos) {
        this.lottos = lottos;
    }

    public LottoAggregator matching(WinningNumbers winnerNumbers) {
        LottoAggregator lottoAggregator = new LottoAggregator();
        for (PickNumbers pickNumbers : lottos.getPickNumbers()) {
            lottoAggregator.put(winnerNumbers.match(pickNumbers));
        }
        return lottoAggregator;
    }

}
