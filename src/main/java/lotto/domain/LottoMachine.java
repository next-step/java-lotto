package lotto.domain;

import java.util.List;

public interface LottoMachine {
    List<Lotto> createAutoLotto(LottoRequest lottoRequest);
    List<Lotto> createManualLotto(LottoRequest lottoRequest);
}
