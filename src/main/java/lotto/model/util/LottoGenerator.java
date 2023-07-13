package lotto.model.util;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public interface LottoGenerator {

    List<LottoNumber> generate();
}
