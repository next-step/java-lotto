package com.nextstep.camp.lotto.domain.strategy;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;

import java.util.List;

@FunctionalInterface
public interface LottoPickStrategy {
    List<LottoTicket> generate();
}
