package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningLottos {

    private Map<Integer, Integer> winningLottos = new HashMap<>();


    public Integer countLottoByWinningNumber(int count) {
        return winningLottos.getOrDefault(count, 0);
    }

    public void putWinningMatchingNumberLotto(int count) {
        winningLottos.put(count, countLottoByWinningNumber(count) + 1);
    }
}
