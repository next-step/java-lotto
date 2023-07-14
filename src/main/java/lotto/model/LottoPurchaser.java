package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {

    private final AutoLottoGenerator autoLottoGenerator;

    public LottoPurchaser(final AutoLottoGenerator autoLottoGenerator) {
        this.autoLottoGenerator = autoLottoGenerator;
    }

    public PurChasedLottos purchaseLotto(final LottoMoney lottoMoney) {
        final int lottoCount = lottoMoney.getLottoCount();
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(autoLottoGenerator.generate());
        }
        return new PurChasedLottos(lottos, lottoMoney);
    }
}
