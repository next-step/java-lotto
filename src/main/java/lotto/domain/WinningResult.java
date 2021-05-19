package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private final List<WinningType> winningType;

    public WinningResult(List<WinningType> winningType) {
        this.winningType = winningType;
    }

    public List<WinningType> getResults() {
        return new ArrayList<>(winningType);
    }
}
