package lotto.domain;

import lotto.domain.generate.LottoAutoGenerator;
import lotto.domain.generate.LottoManualGenerator;
import lotto.domain.generate.LottosGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    List<LottosGenerator> lottosGenerators;

    public LottoGame() {
        lottosGenerators = new ArrayList<>();
        lottosGenerators.add(new LottoManualGenerator());
        lottosGenerators.add(new LottoAutoGenerator());
    }


    public BundleLotto generateLottoNumber(LottoCountManager lottoCountManager) {
        BundleLotto lottos = new BundleLotto();
        for (LottosGenerator lottosGenerator : lottosGenerators) {
            lottos = lottosGenerator.generate(lottoCountManager, lottos);
        }
        return lottos;
    }
}
