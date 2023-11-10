package lotto.domain;

import java.util.Map;

public class WinningResult {

    private final Map<RankLotto, Integer> result;

    public WinningResult(Map<RankLotto, Integer> result) {
        this.result = result;
    }

    public Map<RankLotto, Integer> result() {
        return result;
    }

}
