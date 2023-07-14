package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.game.Lotto;
import lotto.domain.game.Lottos;
import lotto.domain.game.NumberGenerator;
import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;
import lotto.domain.statistics.LottoResults;
import lotto.domain.statistics.LottoStatistics;

public final class LottoService {

    private final Payment payment;
    private final Lottos lottos;
    private final NumberGenerator numberGenerator;
    private LottoStatistics lottoStatistics;

    public LottoService(final Payment payment) {
        this.payment = payment;
        this.numberGenerator = new NumberGenerator();
        this.lottos = generateLottos();
    }

    private Lottos generateLottos() {
        int count = payment.getLottoCount();
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoLottos.add(new Lotto(numberGenerator.shuffleNumbers(), true));
        }
        return new Lottos(autoLottos);
    }

    public LottoResults getResult(final WinningNumber winningNumber) {
        lottoStatistics = new LottoStatistics(lottos, winningNumber, payment);
        return new LottoResults(lottoStatistics);
    }

    public LottoStatistics getProfitRate() {
        return lottoStatistics;
    }

    public int getCount() {
        return payment.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }
}
