package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusesResponseDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        MoneyRequestDto moneyRequestDto = inputView.inputMoney();
        Money money = new Money(moneyRequestDto.getMoney());
        Lottos lottos = lottoService.buyLotto(money);
        outputView.printBuyStatus(new LottoStatusesResponseDto(lottos));

        WinningNumbersRequestDto winningNumbersRequestDto = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(
                winningNumbersRequestDto.getWinningNumbers(),
                winningNumbersRequestDto.getBonusNumber()
        );
        LottoResults lottoResults = lottoService.matchWinningLotto(lottos, winningNumbers);
        ProfitRate profitRate = lottoService.profitRate(lottoResults, money);
        outputView.printLottoResult(new LottoResultResponseDto(lottoResults, profitRate));
    }
}
