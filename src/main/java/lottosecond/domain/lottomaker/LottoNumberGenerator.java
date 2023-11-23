package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<LottoNumber> makeLottoNumberList();
}
