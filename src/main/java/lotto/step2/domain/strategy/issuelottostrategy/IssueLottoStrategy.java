package lotto.step2.domain.strategy.issuelottostrategy;

import lotto.step2.domain.LottoNumber;

import java.util.List;

public interface IssueLottoStrategy {
    List<List<LottoNumber>> issueLottoList();
}
