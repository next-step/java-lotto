package lotto.domain.machine;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public interface LottoGenerator {
    Lotto generate(List<LottoBall> candidates);
}
