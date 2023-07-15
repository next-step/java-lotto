package lotto.controller;

import lotto.domain.*;
import lotto.dto.request.ManualLottosRequestDto;
import lotto.dto.request.MoneyRequestDto;
import lotto.dto.request.WinningNumbersRequestDto;
import lotto.dto.response.LottoResultResponseDto;
import lotto.dto.response.LottoStatusesResponseDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Money money = inputMoney();
        Lottos lottos = buyLottos(money);
        findWinningLottos(money, lottos);
    }

    private Money inputMoney() {
        MoneyRequestDto moneyRequestDto = inputView.inputMoney();
        return new Money(moneyRequestDto.getMoney());
    }

    private Lottos buyLottos(Money money) {
        ManualLottosRequestDto manualLottosRequestDto = inputView.inputManualLottos();
        List<Lotto> manualLottos = manualLottosRequestDto.getManualLottos()
                .stream().map(lotto -> new Lotto(lotto.getManualLotto()))
                .collect(Collectors.toList());
        Lottos lottos = lottoMachine.buyLotto(money, new Lottos(manualLottos));
        outputView.printBuyStatus(new LottoStatusesResponseDto(lottos, new LottosCount(manualLottos.size())));
        return lottos;
    }

    private void findWinningLottos(Money money, Lottos lottos) {
        WinningNumbersRequestDto winningNumbersRequestDto = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(
                winningNumbersRequestDto.getWinningNumbers(),
                winningNumbersRequestDto.getBonusNumber()
        );
        LottoResults lottoResults = lottoMachine.matchWinningLotto(lottos, winningNumbers);
        ProfitRate profitRate = lottoMachine.profitRate(lottoResults, money);
        outputView.printLottoResult(new LottoResultResponseDto(lottoResults, profitRate));
    }


}
