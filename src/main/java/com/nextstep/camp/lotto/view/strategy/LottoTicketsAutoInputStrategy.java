package com.nextstep.camp.lotto.view.strategy;

import java.util.List;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.entity.LottoTicket;
import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.strategy.LottoAutoPicker;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

public class LottoTicketsAutoInputStrategy implements InputStrategy<LottoTickets> {

    private final LottoAmount lottoAmount;

    private LottoTicketsAutoInputStrategy(LottoAmount lottoAmount) {
        this.lottoAmount = lottoAmount;
    }

    public static LottoTicketsAutoInputStrategy of(LottoAmount lottoAmount) {
        return new LottoTicketsAutoInputStrategy(lottoAmount);
    }

    @Override
    public LottoTickets read() {
        List<LottoTicket> lottoTickets = LottoAutoPicker.of(lottoAmount).pick();
        return LottoTickets.of(lottoTickets);
    }
}
