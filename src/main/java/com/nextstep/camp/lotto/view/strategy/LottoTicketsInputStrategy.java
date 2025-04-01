package com.nextstep.camp.lotto.view.strategy;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.strategy.LottoPickStrategy;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

public class LottoTicketsInputStrategy implements InputStrategy<LottoTickets> {
    private final LottoPickStrategy pickStrategy;
    private LottoTicketsInputStrategy(LottoPickStrategy pickStrategy) {
        this.pickStrategy = pickStrategy;
    }

    public static LottoTicketsInputStrategy of(LottoPickStrategy pickStrategy) {
        return new LottoTicketsInputStrategy(pickStrategy);
    }

    @Override
    public LottoTickets read() {
        return LottoTickets.of(pickStrategy);
    }
}
