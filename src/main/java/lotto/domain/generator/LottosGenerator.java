package lotto.domain.generator;

import lotto.domain.Lottos;
import lotto.domain.Money;

public interface LottosGenerator {
    Lottos generate(Money money);
}
