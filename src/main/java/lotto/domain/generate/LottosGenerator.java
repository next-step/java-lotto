package lotto.domain.generate;

import lotto.domain.BundleLotto;
import lotto.domain.LottoCountManager;

public interface LottosGenerator {

    BundleLotto generate(LottoCountManager lottoCountManager, BundleLotto lottos);

}
