package lotto.domain;


public class LottoGame {

    public BundleLotto makeLotto(LottoCountManager lottoCountManager, BundleLotto lottos) {
        for (int i = 0; i < lottoCountManager.getAutoLottoCount(); i++) {
            lottos.addLotto(new Lotto());
        }
        return lottos;
    }
}
