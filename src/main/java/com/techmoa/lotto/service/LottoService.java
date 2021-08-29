package com.techmoa.lotto.service;

import com.techmoa.lotto.model.LottoWinResult;
import com.techmoa.lotto.model.LottoWinScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoService {

    private static int purchaseAmount = 0;
    private static int purchaseLottoTicket = 0;
    private static int countLottoTicket = 0;
    private static final int PURCHASE_LOTTO_PRICE = 1000;

    private static LottoTickets lottoTickets = null;

    public void createLotto(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
        buyLotto(purchaseAmount);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        LottoTicket lottoTicket = null;
        for(int i= 0; i< countLottoTicket; i++) {
            lottoTicket = new LottoTicket();
            lottoTicketList.add(lottoTicket.makeLottoNumber());
        }
        lottoTickets = new LottoTickets(lottoTicketList);
    }

    public void buyLotto(int purchaseAmount) {
        this.countLottoTicket = purchaseAmount / PURCHASE_LOTTO_PRICE ;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public LottoWinResult checkWinnings(LottoAnswer lottoAnswer , LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        List<List<Integer>> lottoResults = new ArrayList<>();
        for(LottoTicket lottoTicket : lottoTicketList) {
            List<Integer> ownLottoTicket = lottoTicket.getLottoNumber();
            ownLottoTicket.retainAll(lottoAnswer.getLottoAnswerNumber());
            lottoResults.add(ownLottoTicket);
        }
        HashMap<Integer,Integer> winResult = saveResults(lottoResults);
        Float profitRatio = calculatorProfitRatio(winResult);
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
        int winCount = position;
        return Long.valueOf(lottoResults.stream()
                .filter(s -> s.size() == winCount)
                .count()).intValue();
    }

    public Float calculatorProfitRatio(HashMap<Integer,Integer> winResult) {
        LottoWinScope[] lottoWinScope = LottoWinScope.values();
        int winMoney = 0;
        for(int i= 0; i< lottoWinScope.length; i++){
            winMoney += winResult.get(lottoWinScope[i].getSameCount()) * lottoWinScope[i].getWinMoney();
        }
        return ((float)winMoney / (float)purchaseAmount) ;
    }
}
