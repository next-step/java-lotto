package lotto.application.dto;

import lotto.domain.WinningAmount;

import java.util.HashMap;

public class LottoResponse {
    private int rateOfReturn;
    private HashMap<WinningAmount, Integer> countAllWinning;

    public LottoResponse(int rateOfReturn, HashMap<WinningAmount, Integer> countAllWinning) {
        this.rateOfReturn = rateOfReturn;
        this.countAllWinning = countAllWinning;
    }

    public int getRateOfReturn() {
        return rateOfReturn;
    }

    public HashMap<WinningAmount, Integer> getCountAllWinning() {
        return countAllWinning;
    }
}
