package lotto;

import java.util.*;

public class LottoGame {

    private Map<Integer, WinningLotto> result = new HashMap<>();

    public void add(int round, WinningLotto winningLotto) {
        result.put(round, winningLotto);
    }

    public WinningLotto get(int round) {
        return result.get(round);
    }

}
