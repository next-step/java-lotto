package lotto.domain;

import java.util.List;

public interface LottoNumberGenerator {

    List<LottoNumber> getNumbers(int size);
}
