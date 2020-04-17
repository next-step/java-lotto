package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.MatchResult;
import lotto.domain.WinningNumbers;

public class LottoService {

    public static MatchResult playLotto(Lottos lottos, WinningNumbers winningInput) {
        return lottos.getResult(winningInput);
    }

}
