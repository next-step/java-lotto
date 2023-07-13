package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.game.Lotto;
import lotto.domain.statistics.LottoMatch;
import lotto.domain.statistics.LottoStatistics;
import lotto.domain.game.Lottos;
import lotto.domain.game.NumberGenerator;
import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;

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

    public Map<LottoMatch, Integer> getResult(final WinningNumber winningNumber) {
        lottoStatistics = new LottoStatistics(lottos, winningNumber, payment);
        return lottoStatistics.getStatistics();
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
