package lotto.controller;

import lotto.dto.LottoNumberResponse;
import lotto.model.AutomaticPurchase;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoPaper;
import lotto.model.ManualPurchase;
import lotto.model.Money;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.LottoMachine.EMPTY;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Money money = inputView.askMoney();

        List<String> manualLotto = inputView.askManualLotto(money);
        int manualQuantity = manualLotto.size();
        int automaticQuantity = money.maxQuantity() - manualQuantity;

        LottoPaper lottoPaper = requestLottoOrder(automaticQuantity, manualLotto);

        printOrderResponse(lottoPaper, manualQuantity, automaticQuantity);

        printLottoPrizeResult(lottoPaper);
    }

    private LottoPaper requestLottoOrder(int automaticQuantity, List<String> manualLotto) {
        LottoMachine automaticPurchase = new AutomaticPurchase();
        LottoMachine manualPurchase = new ManualPurchase();

        List<Lotto> automaticLottos = automaticPurchase.purchase(automaticQuantity, EMPTY);
        List<Lotto> manualLottos = manualPurchase.purchase(manualLotto.size(), manualLotto);

        return new LottoPaper(automaticLottos, manualLottos);
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
        WinningLotto winningInfo = inputView.askWinningLotto();

        Prize prize = lottoPaper.matches(winningInfo);
        int quantityTotal = lottoPaper.getQuantityTotal();

        resultView.printResult(prize, prize.rateOfReturn(quantityTotal));
    }
}
