package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGameController {

    public static void main(String[] args) {

        PurchasePrice purchasePrice = getPurchasePrice();

        LottoTickets lottoTickets = getLottoTickets(purchasePrice);

        List<Rank> rankList = getRank(lottoTickets);

        getYield(lottoTickets, rankList);

    }

    private static void getYield(LottoTickets lottoTickets, List<Rank> rankList) {
        BigDecimal yieldResult = lottoTickets.getYield(rankList);
        printYield(yieldResult);
    }

    private static List<Rank> getRank(LottoTickets lottoTickets) {
        List<Integer> winnerNumberList = inputWinnerNumberList();
        Integer bonusNumber = inputBonusNumber();
        List<Rank> rankList = lottoTickets.putRankings(new LottoNumbers(winnerNumberList, bonusNumber));
        printRanks(rankList);
        return rankList;
    }

    private static LottoTickets getLottoTickets(PurchasePrice purchasePrice) {
        LottoTickets pickedLottoTickets = new LottoTickets(purchasePrice).pickNumbers();
        printLottoNumbers(pickedLottoTickets);
        return pickedLottoTickets;
    }

    private static PurchasePrice getPurchasePrice() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        printPurchaseAmount(purchasePrice);
        return purchasePrice;
    }
}
