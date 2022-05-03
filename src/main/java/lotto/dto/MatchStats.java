package lotto.dto;

import lotto.constant.MatchResult;

public class MatchStats {

    private int count;
    private MatchResult matchResult;

    public MatchStats(int count, MatchResult matchResult) {
        this.count = count;
        this.matchResult = matchResult;
    }

    public int count() {
        return count;
    }

    public MatchResult matchResult() {
        return matchResult;
    }
}
