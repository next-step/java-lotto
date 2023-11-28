package step2.lotto.strategy;

import java.util.List;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoPurchase;

public interface LottoNumberGenerator {
    List<Lotto> generateLottos(final LottoPurchase lottoPurchase);
}
