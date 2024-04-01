package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.publish.LottoCalculator;
import lotto.domain.publish.LottoGenerator;
import lotto.domain.reward.LottoJudge;
import lotto.domain.reward.LottoResult;

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

    public LottoResult judge(final List<Lotto> lottos, final int[] winningNumbers, final int winningBonusNumber) {
        final Lotto winningLotto = Lotto.from(winningNumbers, winningBonusNumber);

        return lottoJudge.judge(lottos, winningLotto);
    }
}
