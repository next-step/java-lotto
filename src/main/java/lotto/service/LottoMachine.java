package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.publish.LottoCalculator;
import lotto.domain.publish.LottoGenerator;
import lotto.domain.reward.LottoJudge;
import lotto.domain.reward.LottoResult;
import lotto.domain.reward.WinningLotto;

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

    public Lottos publish(final int totalPrice, final List<List<Integer>> manualNumbers) {
        final int autoQuantity = lottoCalculator.calculateAutoQuantity(totalPrice, manualNumbers.size());
        final List<Lotto> manualLottos = lottoGenerator.generateManualLottos(manualNumbers);
        final List<Lotto> autoLottos = lottoGenerator.generateAutoLottos(autoQuantity);

        return new Lottos(manualLottos, autoLottos);
    }

    public LottoResult judge(final Lottos lottos, final WinningLotto winningLotto) {
        return lottoJudge.judge(lottos, winningLotto);
    }
}
