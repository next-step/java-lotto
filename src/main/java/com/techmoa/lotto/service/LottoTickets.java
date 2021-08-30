package com.techmoa.lotto.service;

import com.techmoa.lotto.model.LottoWinResult;
import com.techmoa.lotto.model.LottoWinScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoWinResult checkWinnings(LottoAnswer lottoAnswer) {
        List<List<Integer>> lottoResults = new ArrayList<>();
        for(LottoTicket lottoTicket : lottoTickets) {
            List<Integer> ownLottoTicket = lottoTicket.getLottoNumber();
            ownLottoTicket.retainAll(lottoAnswer.getLottoAnswerNumber());
            lottoResults.add(ownLottoTicket);
        }
        HashMap<Integer,Integer> winResult = saveResults(lottoResults);
        Float profitRatio = calculatorProfitRatio(winResult,lottoAnswer.getPurchaseAmount());
        return new LottoWinResult(winResult, profitRatio);
    }

    public HashMap<Integer,Integer> saveResults(List<List<Integer>> lottoResults) {
        HashMap<Integer,Integer> winResult = new HashMap<>();
        for(int i= 1; i<= 6; i++ ) {
            int winCountResult = checkWinCountResult(lottoResults, i);
            winResult.put(i,winCountResult);
        }
        return winResult;
    }

    public int checkWinCountResult(List<List<Integer>> lottoResults , int position) {
        return Long.valueOf(lottoResults.stream()
                .filter(s -> s.size() == position)
                .count()).intValue();
    }

    public Float calculatorProfitRatio(HashMap<Integer,Integer> winResult , int purchaseAmount) {
        LottoWinScope[] lottoWinScope = LottoWinScope.values();
        int winMoney = 0;
        for (LottoWinScope winScope : lottoWinScope) {
            winMoney += winResult.get(winScope.getSameCount()) * winScope.getWinMoney();
        }
        return ((float)winMoney / (float)purchaseAmount) ;
    }
}
