package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {

    private final LottoFactory lottoFactory;

    public LottoPurchaser(final LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public PurChasedLottos purchaseLotto(final Automatic automatic, final Manuals manuals) {
        List<Lotto> lottos = new ArrayList<>();
        purchaseLottosByManual(manuals, lottos);
        purchaseLottoByAuto(automatic, lottos);
        return new PurChasedLottos(lottos, automatic.getAutoCount(), manuals.getManualCount());
    }

    private void purchaseLottosByManual(final Manuals manuals, final List<Lotto> lottos) {
        for (var manualNumber : manuals.getManualNumbers()) {
            lottos.add(lottoFactory.generate(manualNumber));
        }
    }

    private void purchaseLottoByAuto(final Automatic automatic, final List<Lotto> lottos) {
        lottos.addAll(lottoFactory.generate(automatic.getAutoCount()));
    }
}
