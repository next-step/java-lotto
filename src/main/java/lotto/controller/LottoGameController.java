package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;
import lotto.domain.LottoResult;

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
        printPickedLottoTickets(pickedLottoTickets);

        List<Integer> matchNumberList = inputMatchNumberList();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(matchNumberList);

        LottoResult lottoResult = new LottoResult();
        List<Rank> rankList = lottoResult.rankResult(rankedLottoTickets);
        printRankedLottoTickets(rankList);

        Integer yieldResult = lottoResult.yieldResult(rankedLottoTickets);
        printYieldLottoTickets(yieldResult);

    }
}
