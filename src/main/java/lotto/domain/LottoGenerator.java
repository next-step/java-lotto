package lotto.domain;

import java.util.List;

public interface LottoGenerator {
    List<Ticket> generate(Money money);
}
