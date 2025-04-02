package com.nextstep.camp.lotto.domain.strategy;

import java.util.List;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;

@FunctionalInterface
public interface LottoPickStrategy {
    List<LottoTicket> pick();
}
