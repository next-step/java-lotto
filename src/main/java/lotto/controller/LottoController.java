package lotto.controller;

import lotto.dto.LottoNumberResponse;
import lotto.dto.OrderRequest;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
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
        int money = inputView.askMoney();
        OrderRequest request = new OrderRequest(money);
        LottoPaper lottoPaper = LottoMachine.purchase(request);

        List<LottoNumberResponse> lottoNumberResponses = convertToLottoNumberResponse(lottoPaper);
        resultView.printOrderResponse(lottoNumberResponses);

        Lotto winningNumberLotto = inputView.askWinningNumbers();
        LottoNumber bonusNumber = inputView.askBonusNumber(winningNumberLotto);
        WinningLotto winningInfo = new WinningLotto(winningNumberLotto, bonusNumber);

        Prize prize = lottoPaper.matches(winningInfo);

        resultView.printResult(prize, prize.rateOfReturn(lottoPaper.getQuantity()));
    }

    private List<LottoNumberResponse> convertToLottoNumberResponse(LottoPaper lottoPaper) {
        List<List<String>> lottoNumberList = lottoPaper.mapToList();
        return lottoNumberList.stream()
                .map(LottoNumberResponse::new)
                .collect(Collectors.toList());
    }
}
