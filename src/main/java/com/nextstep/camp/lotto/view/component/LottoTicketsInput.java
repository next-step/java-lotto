package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;

public class LottoTicketsInput extends AbstractInput<LottoTickets> {

    private LottoTicketsInput(InputStrategy<LottoTickets> inputStrategy) {
        super(inputStrategy);
    }

    public static LottoTicketsInput create(InputStrategy<LottoTickets> inputStrategy) {
        return new LottoTicketsInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "14개를 구매했습니다.";
    }

    @Override
    public LottoTickets action() {
        LottoTickets lottoTickets = super.action();
        System.out.println(lottoTickets);
        return lottoTickets;
    }
}
