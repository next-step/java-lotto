package autolotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottosComparer {

    private final Map<Integer,Integer> matchingNumbers = new HashMap<Integer, Integer>() {
        {
            for (int i = 3; i < 7; i++) {
                put(i,0);
            }
        }
    };
    private int matchingCount;

    public LottosComparer(Lottos lottos, Lotto winningLotto) {
        for (int i = 0; i < lottos.getLottosCount(); i++) {
            lottos.matchLotto(i,winningLotto, this);
        }
    }

    public int getMatchingCount(int matchingNumber) {
        return matchingNumbers.get(matchingNumber);
    }

    public void addMatchingCount(){
        matchingCount++;
    }

    public void addMatchingNumbers(){
        if (3 < matchingCount && matchingCount < 7) {
            matchingNumbers.put(matchingCount, matchingNumbers.get(matchingCount) + 1);
        }

        matchingCount = 0;
    }
}
