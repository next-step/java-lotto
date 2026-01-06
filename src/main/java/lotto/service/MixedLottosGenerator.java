package lotto.service;

import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;

public class MixedLottosGenerator implements LottoGenerator {
    private final LottoGenerator manualGenerator;
    private final LottoGenerator autoGenerator;

    private MixedLottosGenerator(LottoGenerator manual, LottoGenerator auto) {
        this.manualGenerator = manual;
        this.autoGenerator = auto;
    }

    public static MixedLottosGenerator of(Lottos manualLottos, LottoPurchase purchase) {
        purchase.validateManualCount(manualLottos.size());
        return new MixedLottosGenerator(
                new ManualLottosGenerator(manualLottos),
                new AutoLottosGenerator(purchase.size() - manualLottos.size())
        );
    }

    @Override
    public Lottos generate() {
        Lottos manual = manualGenerator.generate();
        Lottos auto = autoGenerator.generate();
        return manual.merge(auto);
    }
}
