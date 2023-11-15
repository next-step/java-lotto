package lotto.application.dto;

import lotto.domain.WinningAmount;

import java.util.HashMap;

public class LottoResponse {
    private String rateOfReturn;
    private HashMap<WinningAmount, Integer> countAllWinning;

    public LottoResponse(String rateOfReturn, HashMap<WinningAmount, Integer> countAllWinning) {
        this.rateOfReturn = rateOfReturn;
        this.countAllWinning = countAllWinning;
    }

    public String getRateOfReturn() {
        return rateOfReturn;
    }

    public HashMap<WinningAmount, Integer> getCountAllWinning() {
        return countAllWinning;
    }
}
