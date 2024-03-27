package lotto.service;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.publish.LottoGenerator;
import lotto.domain.reward.LottoCalculator;
import lotto.domain.reward.LottoJudge;
import lotto.domain.reward.LottoRank;

public class LottoMachine {

    private final LottoCalculator lottoCalculator;
    private final LottoGenerator lottoGenerator;
    private final LottoJudge lottoJudge;

    public LottoMachine(
            final LottoCalculator lottoCalculator,
            final LottoGenerator lottoGenerator,
            final LottoJudge lottoJudge
    ) {
        this.lottoCalculator = lottoCalculator;
        this.lottoGenerator = lottoGenerator;
        this.lottoJudge = lottoJudge;
    }

    public List<Lotto> publish(final int totalPrice) {
        final int quantity = lottoCalculator.calculateQuantity(totalPrice);

        return lottoGenerator.generateLottos(quantity);
    }

    public Map<LottoRank, Long> judge(final List<Lotto> lottos, final int[] winningNumbers) {
        final Lotto winningLotto = Lotto.from(winningNumbers);

        return lottoJudge.judge(lottos, winningLotto);
    }

    public double calculate(final Map<LottoRank, Long> lottoResult, final int totalPrice) {
        return lottoCalculator.calculateProfitRate(lottoResult, totalPrice);
    }
}
