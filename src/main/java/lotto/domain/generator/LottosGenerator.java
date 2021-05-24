package lotto.domain.generator;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Money;

public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
