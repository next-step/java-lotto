package lotto.domain.machine;

import java.util.List;
import lotto.domain.lotto.Lotto;

public interface LottoGenerator {
    Lotto generate(List<Integer> candidates);
}
