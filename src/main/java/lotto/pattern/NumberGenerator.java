package lotto.pattern;

import lotto.domain.LottoNumber;

import java.util.List;

public interface NumberGenerator {
    int generator();
    List<LottoNumber> generateLottoNumbers();
}
