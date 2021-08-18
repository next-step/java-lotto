package edu.nextstep.lottoauto.view.form;

import edu.nextstep.lottoauto.domain.Prize;

import java.util.Map;

public class WinningResultForm {

    private final Map<Prize, Integer> winningResult;
    private final double rateOfReturn;

    public WinningResultForm(Map<Prize, Integer> winningResult, double rateOfReturn) {
        this.winningResult = winningResult;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Prize, Integer> getWinningResult() {
        return winningResult;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

}
