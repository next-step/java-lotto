package step2.dto;

import java.util.Collections;
import java.util.Map;

public class WinningResult {

    private final Map<String, Long> winningResult;

    public WinningResult(Map<String, Long> result) {
        this.winningResult = result;
    }

    public Map<String, Long> getResults() {
        return Collections.unmodifiableMap(winningResult);
    }
}
