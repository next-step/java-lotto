package lotto.domain;

import java.util.List;

public interface LottoMachine {
    public List<Lotto> createLotto(LottoRequest lottoRequestCard);
}
