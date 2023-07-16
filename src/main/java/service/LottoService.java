package service;

import domain.*;

import java.util.List;

public class LottoService {

    public Lottos generateAutoLottos(final long inputMoney) {
        // TODO: Money money = new Money(inputMoney)

        CandidateStrategy randomCandidateStrategy = new RandomCandidateStrategy();
        List<Lotto> lottos = LottoGenerator.generateLottos(inputMoney, randomCandidateStrategy);
        return new Lottos(lottos);
    }

    public LottoResult computeLottoResult(final Lottos lottos, final WinningLotto winningLotto) {
        return new LottoResult(lottos.checkAllLottoResult(winningLotto));
    }

    public WinningLotto generateWinningLotto(final List<Integer> lottoNumbers, final int bonus) {
        final LottoNumber bonusLottoNumber = new LottoNumber(bonus);
        final Lotto lotto = new Lotto(lottoNumbers);

        return new WinningLotto(lotto, bonusLottoNumber);
    }
}
