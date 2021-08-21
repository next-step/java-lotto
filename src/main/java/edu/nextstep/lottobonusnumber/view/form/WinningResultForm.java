package edu.nextstep.lottobonusnumber.view.form;

import edu.nextstep.lottobonusnumber.domain.Prize;

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
