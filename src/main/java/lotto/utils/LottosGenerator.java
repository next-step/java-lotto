package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(final Money money);
}
