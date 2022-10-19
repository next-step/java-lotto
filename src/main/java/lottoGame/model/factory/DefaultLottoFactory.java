package lottoGame.model.factory;

import lottoGame.model.DefaultLotto;
import lottoGame.model.strategy.DefaultLottoStrategy;

public class DefaultLottoFactory extends LottoFactory {
    private final DefaultLottoStrategy defaultStrategy = new DefaultLottoStrategy();


    @Override
    public DefaultLotto createLotto() {
        return new DefaultLotto(defaultStrategy.createLottoNum());
    }
}
