package lotto;

import java.util.HashMap;

public class LottoResult {

    private final HashMap<MatchStatus, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void updateValue(MatchStatus status) {
        int resultCount = 0;
        if (result.containsKey(status)) {
            resultCount = result.get(status);
        }
        result.put(status, resultCount + 1);
    }

    public int getResultCount(MatchStatus status){
        return result.get(status);
    }
}
