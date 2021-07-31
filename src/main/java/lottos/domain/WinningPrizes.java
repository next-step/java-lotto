package lottos.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningPrizes {

    private Map<Integer, Integer> map;

    public WinningPrizes(List<Integer> prizes) {
        map = new HashMap<>();
        for (int i = 0; i < prizes.size(); i++) {
            map.put(i, prizes.get(i));
        }
    }

    public int size() {
        return map.size();
    }

    public int getPrize(int nameOfMatches) {
        return map.getOrDefault(nameOfMatches, 0);
    }
}
