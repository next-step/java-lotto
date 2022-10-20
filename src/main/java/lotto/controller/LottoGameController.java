package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.service.LottoExchangeService;
import lotto.service.LottoResultService;

import java.util.List;

import static lotto.view.InputView.inputMatchNumberList;
import static lotto.view.InputView.inputPurchasePrice;
import static lotto.view.ResultView.*;

public class LottoGameController {

    public static void main(String[] args) {

        Integer inputPurchasePrice = inputPurchasePrice();
        LottoExchangeService lottoExchangeService = new LottoExchangeService();
        LottoTickets lottoTickets = lottoExchangeService.purchaseLottoTickets(inputPurchasePrice);
        purchaseAmount(lottoTickets);

        LottoTickets pickedLottoTickets = lottoTickets.pickNumbers();
        pickedLottos(pickedLottoTickets);

        List<Integer> matchNumberList = inputMatchNumberList();
        LottoTickets rankedLottoTickets = pickedLottoTickets.putRankings(matchNumberList);

        LottoResultService lottoResultService = new LottoResultService();
        List<Rank> rankList = lottoResultService.rankResult(rankedLottoTickets);
        rankedLottos(rankList);

        Integer yieldResult = lottoResultService.yieldResult(rankedLottoTickets);
        yieldLottos(yieldResult);

    }
}
