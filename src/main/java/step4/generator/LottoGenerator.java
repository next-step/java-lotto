package step4.generator;

import step4.model.Lotto;
import step4.model.Money;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(Money money);
}
