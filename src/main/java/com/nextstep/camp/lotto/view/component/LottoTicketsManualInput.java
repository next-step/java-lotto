package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;

public class LottoTicketsManualInput extends AbstractInput<LottoTickets> {

    private LottoTicketsManualInput(InputStrategy<LottoTickets> inputStrategy) {
        super(inputStrategy);
    }

    public static LottoTicketsManualInput create(InputStrategy<LottoTickets> inputStrategy) {
        return new LottoTicketsManualInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "\n수동으로 구매할 로또 번호를 입력해 주세요.";
    }
}
