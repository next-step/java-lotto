package lotto.domain;

import java.util.List;

public interface LottoNumberService {
    List<LottoGame> creation(Money money);
}
