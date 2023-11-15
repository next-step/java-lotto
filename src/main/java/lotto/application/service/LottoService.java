package lotto.application.service;

import lotto.application.dto.LottoRequest;
import lotto.application.dto.LottoResponse;
import lotto.domain.Lottos;
import lotto.domain.WinningAmount;

import java.util.HashMap;

public class LottoService {

    public LottoResponse calculateBenefit(LottoRequest request) {
        Lottos lottos = new Lottos(request.getLottos());
        HashMap<WinningAmount, Integer> countAllWinning = lottos.countAllWinning(request.getWinningLottoNumber());
        int rateOfReturn = calculateRateOfReturn(request.getInputAmount(), countAllWinning);
        return new LottoResponse(rateOfReturn, countAllWinning);
    }

    private int calculateRateOfReturn(Integer inputAmount, HashMap<WinningAmount, Integer> countAllWinning) {
        Integer getAllAmount = 0;
        for (WinningAmount winningAmount : countAllWinning.keySet()) {
            getAllAmount += (winningAmount.getAmount() * countAllWinning.get(winningAmount));
        }
        return getAllAmount / inputAmount;
    }
}
