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
    private LottoStatistics lottoStatistics;

    public LottoService(final Payment payment) {
        this.payment = payment;
        this.lottos = generateLottos();
    }

    private Lottos generateLottos() {
        int count = payment.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> lottoPossibleNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoPossibleNumbers);
            lottos.add(new Lotto(lottoPossibleNumbers.subList(0, LOTTO_PICK_COUNT)));
        }
        return new Lottos(lottos);
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
