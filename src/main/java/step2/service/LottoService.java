package step2.service;

import step2.domain.check.LottoWinningCheckMachine;
import step2.domain.generator.LottoGenerateCount;
import step2.domain.generator.LottoGenerateMachine;
import step2.domain.lotto.Lotto;
import step2.domain.money.Money;
import step2.domain.winning.WinningResult;
import step2.strategy.LottoRandomShuffleStrategy;
import step2.strategy.LottoShuffleStrategy;

import java.util.List;
import java.util.Set;

public final class LottoService {

    private final LottoShuffleStrategy strategy;

    private LottoService(LottoShuffleStrategy strategy) {
        this.strategy = strategy;
    }

    public static final LottoService of() {
        return of(LottoRandomShuffleStrategy.getInstance());
    }

    public static final LottoService of(LottoShuffleStrategy strategy) {
        return new LottoService(strategy);
    }

    public final List<Lotto> getLottos(Money money) {
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.of(money);
        LottoGenerateMachine lottoGenerateMachine = LottoGenerateMachine.of(strategy);
        return lottoGenerateMachine.generateLottos(lottoGenerateCount);
    }

    public final WinningResult getWinningResult(List<Lotto> userLottos, Lotto winningLotto) {
        LottoWinningCheckMachine winningCheckMachine = LottoWinningCheckMachine.of(winningLotto);
        return winningCheckMachine.generateWinningResult(userLottos);
    }

}
