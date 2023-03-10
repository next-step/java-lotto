package lotto.domain;

import lotto.domain.strategy.LottoCreationStrategy;
import lotto.domain.strategy.LottoCreationStrategyFactory;
import lotto.ui.LottoRequest;

public class LottoStore {

    public LottoTickets buyLotto(final LottoRequest request) {
        LottoCreationStrategy strategy = LottoCreationStrategyFactory.createLottoStrategy(request);
        return strategy.createLottoTickets();
    }
}
