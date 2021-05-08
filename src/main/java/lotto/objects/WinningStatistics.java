package lotto.objects;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
    private List<WinningType> winningTypes;

    public WinningStatistics() {
        List<WinningType> winningTypes = new ArrayList<>();

        for (WinningType winningType : WinningType.values()) {
            winningTypes.add(winningType);
        }

        this.winningTypes = winningTypes;
    }

    public List<WinningType> getWinningTypes() {
        return winningTypes;
    }
}
