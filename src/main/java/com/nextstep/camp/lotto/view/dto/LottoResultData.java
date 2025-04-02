package com.nextstep.camp.lotto.view.dto;

import com.nextstep.camp.lotto.domain.entity.WinningStatistics;

public class LottoResultData {
    private final WinningStatistics statistics;

    private LottoResultData(WinningStatistics statistics) {
        this.statistics = statistics;
    }

    public static LottoResultData of(WinningStatistics statistics) {
        return new LottoResultData(statistics);
    }

    public WinningStatistics getStatistics() {
        return statistics;
    }
}
