package com.nextstep.camp.lotto;

import java.util.List;

import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.entity.WinningStatistics;
import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;
import com.nextstep.camp.lotto.view.dto.LottoResultData;
import com.nextstep.camp.lotto.view.handler.LottoResultViewHandler;
import com.nextstep.camp.lotto.view.handler.LottoInputViewHandler;
import com.nextstep.camp.lotto.view.dto.LottoInputData;

public class LottoApplication {

    public static void main(String[] args) {
        LottoInputViewHandler inputViewHandler = LottoInputViewHandler.init();
        LottoInputData lottoInputData = inputViewHandler.handle();

        WinningStatistics winningStatistics = getWinningStatistics(lottoInputData);

        LottoResultData lottoResultData = LottoResultData.of(winningStatistics);
        LottoResultViewHandler resultViewHandler = LottoResultViewHandler.init();
        resultViewHandler.handle(lottoResultData);
    }

    private static WinningStatistics getWinningStatistics(LottoInputData lottoInputData) {
        LottoAmount lottoAmount = lottoInputData.getLottoAmount();
        LottoTickets lottoTickets = lottoInputData.getLottoTickets();
        WinningNumbers winningNumbers = lottoInputData.getWinningNumbers();
        List<MatchResult> matchResults =  lottoTickets.matchAll(winningNumbers);
        return WinningStatistics.of(matchResults, lottoAmount);
    }
}
