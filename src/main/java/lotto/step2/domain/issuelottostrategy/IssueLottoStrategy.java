package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoNumber;

import java.util.List;

public interface IssueLottoStrategy {
    List<List<LottoNumber>> issueLottoList();
}
