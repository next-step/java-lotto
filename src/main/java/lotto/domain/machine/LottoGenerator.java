package lotto.domain.machine;

import java.util.List;
import lotto.domain.lotto.LottoNumber;

public interface LottoGenerator {
    List<LottoNumber> get();
}
