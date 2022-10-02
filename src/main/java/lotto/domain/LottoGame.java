package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final List<Lotto> value;

    public LottoGame(List<Lotto> value) {
        this.value = value;
    }

    public LottoResult getWinningResult(WinningNumbers winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < Lotto.SIZE+1; i++) {
            result.put(i, 0);
        }

        for (Lotto lotto : value) {
            int numberOfEquals = winningNumbers.numberOfEquals(lotto);
            int count = result.get(numberOfEquals) + 1;
            result.put(numberOfEquals, count);
        }
        return new LottoResult(result, value.size());
    }

    public List<Lotto> getValue(){
        return this.value;
    }

}
