package lotto.domain;

import java.util.List;

public interface LottoCreationStrategy {

    List<Lotto> createLottos(int purchaseCount);
}