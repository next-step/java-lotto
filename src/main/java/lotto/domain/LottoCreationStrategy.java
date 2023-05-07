package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoCreationStrategy {

    List<Lotto> createLottos(int purchaseCount);
}
