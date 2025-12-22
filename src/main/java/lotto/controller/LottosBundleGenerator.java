package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoPrice;

import java.util.List;

public class LottosBundleGenerator implements LottoGenerator {
    private final List<LottoGenerator> lottosGenerators;

    public LottosBundleGenerator(LottoPrice price, LottoCount manualCount, List<String> manualLottoText) {
        this(toLottosGenerators(price, manualCount, manualLottoText));
    }

    private static List<LottoGenerator> toLottosGenerators(LottoPrice price, LottoCount manualCount, List<String> manualLottoText) {
        return List.of(new LottoMachine(manualCount.diffFromPrice(price)), new ManualLottoMachine(manualLottoText));
    }

    public LottosBundleGenerator(List<LottoGenerator> lottosGenerators) {
        this.lottosGenerators = lottosGenerators;
    }

    @Override
    public Lotto generate() {
        Lotto lotto = new Lotto();

        for (LottoGenerator lottosGenerator : lottosGenerators) {
            lotto = new Lotto(lotto, lottosGenerator.generate());
        }

        return lotto;
    }
}