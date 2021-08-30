package com.techmoa.lotto.model;

import com.techmoa.lotto.service.LottoAnswer;
import com.techmoa.lotto.service.LottoTicket;
import com.techmoa.lotto.service.LottoTickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum LottoWinScope {

    FOUR_PLACE(3, 5_000){
        public String showLottoResult() {
            return getSameCount() + "개 일치 (" + getWinMoney() + "원)";
        }
    },
    THREE_PLACE(4,  50_000){
        public String showLottoResult() {
            return getSameCount() + "개 일치 (" + getWinMoney() + "원)";
        }
    },
    TWO_PLACE(5, 1_500_000){
        public String showLottoResult() {
            return getSameCount() + "개 일치 (" + getWinMoney() + "원)";
        }
    },
    FIRST(6, 2_000_000_000){
        public String showLottoResult() {
            return getSameCount() + "개 일치 (" + getWinMoney() + "원)";
        }
    },
    ;

    private final int sameCount;
    private final int winMoney;

    LottoWinScope(int sameCount, int winMoney) {
        this.sameCount = sameCount;
        this.winMoney = winMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public abstract String showLottoResult();

    public static LottoWinResult checkWinnings(LottoAnswer lottoAnswer, LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        List<LottoTicket> lottoMatchingResults = new ArrayList<>();

        for(LottoTicket lottoTicket : lottoTicketList) {
            List<Integer> ownLottoTicket = lottoTicket.getLottoNumber();
            ownLottoTicket.retainAll(lottoAnswer.getLottoAnswerNumber());
            lottoMatchingResults.add(new LottoTicket(ownLottoTicket));
        }

        HashMap<Integer,Integer> winResult = saveResultWinCounts(lottoMatchingResults);
        Float profitRatio = calculatorProfitRatio(winResult,lottoAnswer.getPurchaseAmount());
        return new LottoWinResult(winResult, profitRatio);
    }

    public static HashMap<Integer,Integer> saveResultWinCounts(List<LottoTicket> lottoResults) {
        HashMap<Integer,Integer> winResult = new HashMap<>();
        for(int i= 1; i<= 6; i++ ) {
            int winCountResult = checkWinCountResult(lottoResults, i);
            winResult.put(i,winCountResult);
        }
        return winResult;
    }

    public static int checkWinCountResult(List<LottoTicket> lottoResults , int position) {
        return Long.valueOf(lottoResults.stream()
                .filter(s -> s.getLottoNumber().size() == position)
                .count()).intValue();
    }

    public static Float calculatorProfitRatio(HashMap<Integer, Integer> winResult, int purchaseAmount) {
        LottoWinScope[] lottoWinScope = LottoWinScope.values();
        int winMoney = 0;
        for (LottoWinScope winScope : lottoWinScope) {
            winMoney += winResult.get(winScope.getSameCount()) * winScope.getWinMoney();
        }
        return ((float)winMoney / (float)purchaseAmount) ;
    }
}
