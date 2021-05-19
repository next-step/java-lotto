package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private final List<WinningType> winningTypes;

    public WinningResult(List<WinningType> winningTypes) {
        this.winningTypes = winningTypes;
    }

    public long count(WinningType winningType) {
        return winningTypes.stream()
                    .filter(type -> type.equals(winningType))
                    .count();
    }

    public List<WinningType> getResults() {
        return new ArrayList<>(winningTypes);
    }
}
