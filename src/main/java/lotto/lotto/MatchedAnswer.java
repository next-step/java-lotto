package lotto.lotto;

import java.util.HashMap;
import java.util.Map;

public class MatchedAnswer {
    Map<Integer, Integer> matchAnswer = new HashMap<>();

    public int count(int answer) {
        return getOrDefault(answer);
    }

    public void increaseCount(int answer) {
        int count = getOrDefault(answer);
        matchAnswer.put(answer, ++count);
    }

    private int getOrDefault(int answer) {
        return matchAnswer.getOrDefault(answer, 0);
    }
}
