package com.nextstep.camp.lotto.view.strategy;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.LottoCount;
import com.nextstep.camp.lotto.view.component.LottoTicketsAutoInput;
import com.nextstep.camp.lotto.view.component.LottoTicketsManualInput;

public class LottoTicketsInputStrategy implements InputStrategy<LottoTickets> {
    private final LottoAmount lottoAmount;
    private final LottoCount lottoManuelCount;

    private LottoTicketsInputStrategy(LottoAmount lottoAmount, LottoCount lottoManuelCount) {
        this.lottoAmount = lottoAmount;
        this.lottoManuelCount = lottoManuelCount;
    }

    public static LottoTicketsInputStrategy of(LottoAmount lottoAmount, LottoCount lottoCount) {
        return new LottoTicketsInputStrategy(lottoAmount, lottoCount);
    }

    @Override
    public LottoTickets read() {
        LottoTicketsManuelInputStrategy lottoTicketsManuelInputStrategy = LottoTicketsManuelInputStrategy.ofSystemIn(lottoManuelCount);
        LottoTicketsManualInput lottoTicketsManualInput = LottoTicketsManualInput.create(lottoTicketsManuelInputStrategy);
        LottoTickets manualLottoTickets = lottoTicketsManualInput.action();

        LottoCount lottoAutoCount = lottoAmount.getLottoCount().minus(lottoManuelCount);

        LottoTicketsAutoInputStrategy lottoTicketsAutoInputStrategy = LottoTicketsAutoInputStrategy.of(lottoAutoCount);
        LottoTicketsAutoInput lottoTicketsAutoInput = LottoTicketsAutoInput.create(lottoTicketsAutoInputStrategy, lottoAutoCount, lottoManuelCount);
        LottoTickets autoLottoTickets = lottoTicketsAutoInput.action();

        return LottoTickets.of(manualLottoTickets, autoLottoTickets);
    }
}
