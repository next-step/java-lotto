package lotto.lotto;

import java.util.List;

public interface LottoGenerator {
    Lotto generateLotto();
    List<LottoNumber> getLotto();
}
