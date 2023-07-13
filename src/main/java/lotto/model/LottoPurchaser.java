package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.util.LottoGenerator;

public class LottoPurchaser {

    private final LottoGenerator lottoGenerator;

    public LottoPurchaser(final LottoGenerator autoLottoGenerator) {
        this.lottoGenerator = autoLottoGenerator;
    }

    public Lottos purchaseLotto(final LottoMoney lottoMoney) {
        final int lottoCount = lottoMoney.getLottoCount();
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
