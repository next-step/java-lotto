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

        LottoTickets pickedLottoTickets = getLottoTickets(purchasePrice);

        LottoTickets rankedLottoTickets = getLottoTickets(pickedLottoTickets);

        getRank(rankedLottoTickets);

        getYield(rankedLottoTickets);

    }

    private static void getYield(LottoTickets rankedLottoTickets) {
        BigDecimal yieldResult = rankedLottoTickets.getYield();
        printYield(yieldResult);
    }

    private static void getRank(LottoTickets rankedLottoTickets) {
        List<Rank> rankList = rankedLottoTickets.getRank();
        printRanks(rankList);
    }

    private static LottoTickets getLottoTickets(LottoTickets pickedLottoTickets) {
        List<Integer> winnerNumberList = inputWinnerNumberList();
        Integer bonusNumber = inputBonusNumber();
        return pickedLottoTickets.putRankings(new LottoNumbers(winnerNumberList, bonusNumber));
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
