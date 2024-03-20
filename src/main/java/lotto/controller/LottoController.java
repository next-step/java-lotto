package lotto.controller;

import lotto.dto.LottoNumberResponse;
import lotto.dto.OrderRequest;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.model.Money;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        LottoPaper lottoPaper = LottoMachine.purchase(createOrderRequest());

        printOrderResponse(lottoPaper);

        printLottoPrizeResult(lottoPaper);
    }

    private OrderRequest createOrderRequest() {
        Money money = inputView.askMoney();
        int manualQuantity = inputView.askManualQuantity(money);
        List<Lotto> manualLottos = inputView.askManualLotto(manualQuantity);

        return new OrderRequest(money, manualLottos);
    }

    private void printOrderResponse(LottoPaper lottoPaper) {
        List<LottoNumberResponse> lottoNumberResponses = convertToLottoNumberResponse(lottoPaper);
        int manaulQuantity = lottoPaper.getManualQuantity();
        int automaticQuantity = lottoPaper.getAutomaticQuantity();

        resultView.printOrderResponse(lottoNumberResponses, manaulQuantity, automaticQuantity);
    }

    private List<LottoNumberResponse> convertToLottoNumberResponse(LottoPaper lottoPaper) {
        List<List<String>> lottoNumberList = lottoPaper.mapToList();
        return lottoNumberList.stream()
                .map(LottoNumberResponse::new)
                .collect(Collectors.toList());
    }

    private void printLottoPrizeResult(LottoPaper lottoPaper) {
        Lotto winningNumberLotto = inputView.askWinningNumbers();
        LottoNumber bonusNumber = inputView.askBonusNumber(winningNumberLotto);
        WinningLotto winningInfo = new WinningLotto(winningNumberLotto, bonusNumber);

        Prize prize = lottoPaper.matches(winningInfo);
        int quantityTotal = lottoPaper.getQuantityTotal();

        resultView.printResult(prize, prize.rateOfReturn(quantityTotal));
    }
}
