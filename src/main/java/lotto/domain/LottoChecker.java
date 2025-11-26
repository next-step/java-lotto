package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    private Map<Integer, Integer> lottoResult = new HashMap<>();

    public LottoChecker() {
        lottoResult.put(3, 0);
        lottoResult.put(4, 0);
        lottoResult.put(5, 0);
        lottoResult.put(6, 0);
    }

    public int countMatch(Lotto lotto, Lotto winning) {
        int count = 0;
        for (Integer number : lotto.numbers()) {
            if (winning.numbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public Map<Integer, Integer> check(List<Lotto> lottos, Lotto winning) {
        for (Lotto lotto : lottos) {
            int count = countMatch(lotto, winning);
            plusCount(count);
        }
        return lottoResult;
    }

    private void plusCount(int count) {
        Integer value = lottoResult.get(count);
        if (value != null) {
            lottoResult.put(count, value + 1);
        }
    }
}
