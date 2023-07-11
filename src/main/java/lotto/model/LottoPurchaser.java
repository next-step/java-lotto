package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {

    private final AutoLottoGenerator autoLottoGenerator;

    public LottoPurchaser(AutoLottoGenerator autoLottoGenerator) {
        this.autoLottoGenerator = autoLottoGenerator;
    }

    public PurChasedLotto purchaseLotto(LottoMoney lottoMoney) {
        int lottoCount = lottoMoney.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(autoLottoGenerator.generate());
        }
        return new PurChasedLotto(lottos);
    }
}
