package lotto.controller;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGameController {

    public static void main(String[] args) {
        PurchaseInfo purchasePrice = inputPurchaseInfo();
        LottoTickets lottoTickets = getLottoTickets(purchasePrice);
        List<Rank> rankList = getRank(lottoTickets);
        getYield(lottoTickets, rankList);
    }

    private static LottoTickets getLottoTickets(PurchaseInfo purchaseInfo) {
        List<Integer> manualNumberList = getManualNumberList(purchaseInfo.getManualAmount());
        printPurchaseAmount(purchaseInfo);
        LottoTickets lottoTickets = new LottoTickets(purchaseInfo).pickNumbers(manualNumberList);
        printLottoNumbers(lottoTickets);
        return lottoTickets;
    }

    private static List<Rank> getRank(LottoTickets lottoTickets) {
        List<Integer> winnerNumberList = inputWinnerNumberList();
        Integer bonusNumber = inputBonusNumber();
        List<Rank> rankList = lottoTickets.putRankings(new LottoResult(winnerNumberList, bonusNumber));
        printRanks(rankList);
        return rankList;
    }

    private static void getYield(LottoTickets lottoTickets, List<Rank> rankList) {
        BigDecimal yieldResult = lottoTickets.getYield(rankList);
        printYield(yieldResult);
    }
}
