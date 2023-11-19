package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchNumbers {

    private static final String ERROR_OVER_MATCH_COUNT = "맞은 갯수는 최대 6개입니다.";
    private static final String ERROR_UNDER_MATCH_COUNT = "맞은 갯수는 최소 0개입니다.";

    private List<Integer> matchNumbers;

    public MatchNumbers() {
        this.matchNumbers = new ArrayList<>();
    }

    public void add(int matchCount) {
        if (matchCount > 6) {
            throw new IllegalArgumentException(ERROR_OVER_MATCH_COUNT);
        }
        if (matchCount < 0) {
            throw new IllegalArgumentException(ERROR_UNDER_MATCH_COUNT);
        }
        matchNumbers.add(matchCount);
    }

    public int size() {
        return matchNumbers.size();
    }

    public int get(int index) {
        return matchNumbers.get(index);
    }
}
