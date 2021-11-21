package edu.nextstep.camp.lotto.domain;

import java.util.List;

public class FixedLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        return Lotto.of(List.of(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),
                                LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6)));
    }
}
