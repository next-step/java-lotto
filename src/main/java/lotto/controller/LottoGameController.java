package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;

import java.util.List;

import static lotto.view.InputView.inputMatchNumberList;
import static lotto.view.InputView.inputPurchasePrice;
import static lotto.view.ResultView.*;

public class LottoGameController {

    public static void main(String[] args) {

        PurchasePrice purchasePrice = inputPurchasePrice();
        printPurchaseAmount(purchasePrice);

        LottoTickets lottoTickets = new LottoTickets(purchasePrice);
        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        printLottoNumbers(pickedLottoTickets);

        LottoNumbers winnerLottoNumbers = inputMatchNumberList();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(winnerLottoNumbers);

        List<Rank> rankList = rankedLottoTickets.getRank();
        printRanks(rankList);

        Integer yieldResult = rankedLottoTickets.getYield();
        printYield(yieldResult);

    }
}
