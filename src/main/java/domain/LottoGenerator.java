package domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    List<Lotto> generate(Money money);
}
