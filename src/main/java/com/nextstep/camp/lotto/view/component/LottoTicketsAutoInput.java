package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.vo.LottoCount;

public class LottoTicketsAutoInput extends AbstractInput<LottoTickets> {

    private final LottoCount autoCount;
    private final LottoCount manualCount;

    private LottoTicketsAutoInput(InputStrategy<LottoTickets> inputStrategy, LottoCount autoCount, LottoCount manualCount) {
        super(inputStrategy);
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public static LottoTicketsAutoInput create(InputStrategy<LottoTickets> inputStrategy, LottoCount autoCount, LottoCount manualCount) {
        return new LottoTicketsAutoInput(inputStrategy, autoCount, manualCount);
    }

    @Override
    public String getLabel() {
        return String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount.getCount(), autoCount.getCount());
    }

    @Override
    public LottoTickets action() {
        LottoTickets lottoTickets = super.action();
        System.out.println(lottoTickets);
        return lottoTickets;
    }
}
