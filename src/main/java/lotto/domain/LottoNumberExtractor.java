package lotto.domain;

import java.util.List;

public interface LottoNumberExtractor {

    List<LottoNumber> getNumbers(int size);
}
