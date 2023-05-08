package model;

import view.result.ResultView;

import java.util.List;

public class LottosInfoFcade {

    private int buyAmount;
    private List<Lotto> lottos;

    public LottosInfoFcade(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public void view() {
        LottoStore lottoStore = new LottoStore(this.buyAmount);

        LottoRandomGenerator lottoGenerator = new LottoRandomGenerator();
        lottoGenerator.generatorLotto(lottoStore.getCount());

        this.lottos = lottoGenerator.getLottos();

        ResultView.printLottoInfo(this.lottos, lottoStore.getCount());
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
