package lotto;

import java.util.*;

public class LottoGame {

    private Map<Integer, WinningLotto> result = new HashMap<>();

    public void add(int round, Set<LottoNumber> winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(winningNumbers), LottoNumber.of(bonusNumber));
        result.put(round, winningLotto);
    }

    public WinningLotto get(int round) {
        return result.get(round);
    }

}
