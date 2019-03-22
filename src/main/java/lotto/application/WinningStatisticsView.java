package lotto.application;

import lotto.domain.WinningOrder;

import java.util.HashMap;
import java.util.Map;

public class WinningStatisticsView {
    private final Map<WinningOrder, Long> values;

    public WinningStatisticsView(final Map<WinningOrder, Long> values) {
        this.values = new HashMap<>(values);
    }

    public Map<WinningOrder, Long> get() {
        return new HashMap<>(values);
    }
}
