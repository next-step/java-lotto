package lotto;

import lotto.application.LottoResponse;
import lotto.application.LottoResults;
import lotto.application.LottoService;
import lotto.application.WinningLottoRequest;
import lotto.domain.lotto.Lotteries;
import lotto.domain.machine.LottoMachine;
import lotto.domain.money.LottoMoney;
import lotto.ui.InputView;
import lotto.ui.LottoController;
import lotto.ui.ResultView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = setUpLottoController(InputView.requestMoney());
        LottoResponse lottoManualResponse = getManualLottoResponse(lottoController);
        LottoResponse lottoAutoResponse = getAutoLottoResponse(lottoController, lottoManualResponse.boughtCount());
        ResultView.print(lottoManualResponse, lottoAutoResponse);

        LottoResponse allLotteries =
                LottoResponse.of(lottoManualResponse.getLottoResponse(), lottoAutoResponse.getLottoResponse());
        WinningLottoRequest winningLottoRequest =
                WinningLottoRequest.of(allLotteries.getLottoResponse(), InputView.requestWinningLotto());
        LottoResults lottoResults = lottoController.match(winningLottoRequest);
        ResultView.print(lottoResults);
    }

    private static LottoResponse getAutoLottoResponse(LottoController lottoController, int boughtCount) {
        return lottoController.auto(lottoController.pay(boughtCount));
    }

    private static LottoResponse getManualLottoResponse(LottoController lottoController) {
        Lotteries InputManualLottoValues = Lotteries.of(InputView.requestManualLottoNumbers());
        return lottoController.manual(InputManualLottoValues);
    }

    private static LottoController setUpLottoController(int lottoMoney) {
        return new LottoController(new LottoService(new LottoMachine(), LottoMoney.of(lottoMoney)));
    }
}
