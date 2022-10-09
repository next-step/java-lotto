package lotto.model;

import java.util.List;

public interface LottoFactory {

    List<Lotto> create(int purchaseCount);
}
