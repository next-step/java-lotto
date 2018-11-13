package lotto.domain;

import java.util.List;

public interface LottoMachine {
    List<Lotto> createLotto(LottoRequest lottoRequestCard);
}
