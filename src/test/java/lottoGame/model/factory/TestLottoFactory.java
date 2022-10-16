package lottoGame.model.factory;

import lottoGame.model.DefaultLotto;
import lottoGame.model.strategy.TestLottoStrategy;

public class TestLottoFactory extends LottoFactory {
    private final TestLottoStrategy testStrategy = new TestLottoStrategy();

    @Override
    public DefaultLotto createLotto() {
        return new DefaultLotto(testStrategy.createLottoNum());
    }
}
