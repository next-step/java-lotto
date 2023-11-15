package lotto.domain;

import java.util.List;

public interface LottoNumberGenerator {
    List<Lotto> generate(int amount);
}
