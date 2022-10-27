package lotto.controller;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGameController {

    public static void main(String[] args) {
        PurchaseInfo purchaseInfo = inputPurchaseInfo();
        LottoTickets lottoTickets = getLottoTickets(purchaseInfo);
        List<Rank> rankList = getRanks(lottoTickets);
        getYield(lottoTickets, rankList);
    }

    private static LottoTickets getLottoTickets(PurchaseInfo purchaseInfo) {
        List<List<Integer>> manualNumberList = getManualNumberList(purchaseInfo.getManualAmount());
        LottoTickets lottoTickets = new LottoTickets(purchaseInfo).pickNumbers(manualNumberList);
        printPurchaseAmount(purchaseInfo);
        printLottoNumbers(lottoTickets);
        return lottoTickets;
    }

    private static List<Rank> getRanks(LottoTickets lottoTickets) {
        List<Integer> winnerNumberList = inputWinnerNumberList();
        Integer bonusNumber = inputBonusNumber();
        List<Rank> rankList = lottoTickets.getRanks(new LottoResult(winnerNumberList, bonusNumber));
        printRanks(rankList);
        return rankList;
    }

    private static void getYield(LottoTickets lottoTickets, List<Rank> rankList) {
        BigDecimal yieldResult = lottoTickets.getYield(rankList);
        printYield(yieldResult);
    }
}
