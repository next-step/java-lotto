package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    List<Lotto> generateLottos();
}
