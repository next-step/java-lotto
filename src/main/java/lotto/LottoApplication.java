package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(new LottoService());

        MoneyRequestDto moneyRequestDto = inputView.inputMoney();
        LottoStatusResponseDto lottoStatusResponseDto = lottoController.buyLotto(moneyRequestDto);
        outputView.printBuyStatus(lottoStatusResponseDto);

        WinningNumbersRequestDto winningNumbersRequestDto = inputView.inputWinningNumbers();
        LottoResultResponseDto lottoResultResponseDto = lottoController.drawWinningLotto(winningNumbersRequestDto);
        outputView.printLottoResult(lottoResultResponseDto);
    }
}
