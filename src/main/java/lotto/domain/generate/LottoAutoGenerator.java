package lotto.domain.generate;


import lotto.domain.BundleLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoCountManager;

public class LottoAutoGenerator implements LottosGenerator {

    @Override
    public BundleLotto generate(LottoCountManager lottoCountManager, BundleLotto lottos) {
        for (int i = 0; i < lottoCountManager.getAutoLottoCount(); i++) {
            lottos.addLotto(Lotto.auto());
        }
        return lottos;
    }
}
