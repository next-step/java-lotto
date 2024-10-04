package step2.model;

import java.util.HashMap;
import java.util.Map;

public class PrizeStatics {

    private final Map<Integer, Integer> prizes = new HashMap<>();

    //로또당첨
    public void prize(int matchCount) {
        prizes.put(matchCount, prizes.getOrDefault(matchCount, 0) + 1);
    }

    //당첨된 숫자의 로또 개수 가져오기
    public int getPrize(int matchCount) {
        return prizes.getOrDefault(matchCount, 0);
    }

    public Map<Integer, Integer> getPrizes() {
        return prizes;
    }
}
