package com.nextstep.camp.lotto.view.strategy;

import java.util.List;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.entity.LottoTicket;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.strategy.LottoAutoPicker;
import com.nextstep.camp.lotto.domain.vo.LottoCount;

public class LottoTicketsAutoInputStrategy implements InputStrategy<LottoTickets> {

    private final LottoCount lottoCount;

    private LottoTicketsAutoInputStrategy(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoTicketsAutoInputStrategy of(LottoCount lottoAmount) {
        return new LottoTicketsAutoInputStrategy(lottoAmount);
    }

    @Override
    public LottoTickets read() {
        List<LottoTicket> lottoTickets = LottoAutoPicker.of(lottoCount).pick();
        return LottoTickets.of(lottoTickets);
    }
}
