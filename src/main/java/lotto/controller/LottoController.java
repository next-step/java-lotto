package lotto.controller;

import lotto.dto.LottoNumberResponse;
import lotto.model.AutomaticPurchase;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.model.ManualPurchase;
import lotto.model.Money;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Money money = inputView.askMoney();
        int manualQuantity = inputView.askManualQuantity(money);
        int automaticQuantity = money.maxQuantity() - manualQuantity;

        LottoPaper lottoPaper = requestLottoOrder(manualQuantity, automaticQuantity);

        printOrderResponse(lottoPaper, manualQuantity, automaticQuantity);

        printLottoPrizeResult(lottoPaper);
    }

    private LottoPaper requestLottoOrder(int manualQuantity, int automaticQuantity) {
        LottoMachine automaticPurchase = new AutomaticPurchase();
        LottoMachine manualPurchase = new ManualPurchase(new Scanner(System.in));

        List<Lotto> automaticLotto = automaticPurchase.purchase(automaticQuantity);
        List<Lotto> manualLotto = manualPurchase.purchase(manualQuantity);

        return new LottoPaper(automaticLotto, manualLotto);
    }

    private void printOrderResponse(LottoPaper lottoPaper, int manualQuantity, int automaticQuantity) {
        List<LottoNumberResponse> lottoNumberResponses = convertToLottoNumberResponse(lottoPaper);
        resultView.printOrderResponse(lottoNumberResponses, manualQuantity, automaticQuantity);
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
