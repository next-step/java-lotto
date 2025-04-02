package com.nextstep.camp.lotto.view;

import com.nextstep.camp.lotto.domain.entity.WinningStatistics;
import com.nextstep.camp.lotto.domain.strategy.LottoAutoPickStrategy;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.view.component.*;
import com.nextstep.camp.lotto.view.dto.LottoInputData;
import com.nextstep.camp.lotto.view.dto.LottoResultData;
import com.nextstep.camp.lotto.view.strategy.*;

public class LottoResultView {
    private final LottoResultData lottoResultData;
    private final WinningStatisticsResult winningStatisticsResult;

    private LottoResultView(LottoResultData lottoResultData) {
        this.lottoResultData = lottoResultData;
        WinningStatistics statistics = this.lottoResultData.getStatistics();
        this.winningStatisticsResult = WinningStatisticsResult.create(statistics);
    }

    public static LottoResultView publish(LottoResultData lottoResultData) {
        return new LottoResultView(lottoResultData);
    }

    public void render() {
        this.winningStatisticsResult.action();
    }
}
