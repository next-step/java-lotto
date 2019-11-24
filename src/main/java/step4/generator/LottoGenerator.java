package step4.generator;

import step4.model.Lottos;
import step4.model.Money;

public interface LottoGenerator {
    Lottos generate(Money money);
}
