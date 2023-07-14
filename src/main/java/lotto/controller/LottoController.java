package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.ManualRequestDto;
import lotto.dto.WinningLottoRequestDto;
import lotto.service.LottoService;
import lotto.util.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        Money money = new Money(inputView.inputMoney().getMoney());
        ManualRequestDto manualRequestDto = inputView.inputManualLottoNumber();
        Lottos manualLotto = Lottos.from(manualRequestDto.getManualLottos());
        this.lottoService = LottoService.buyLotto(money, manualLotto, new RandomGenerator());

        outputView.printBuyStatus(lottoService.buyStatus());
    }

    public void drawWinningLotto() {
        WinningLottoRequestDto winningLottoRequestDto = inputView.inputWinningLotto();
        WinningLotto winningLotto = new WinningLotto(
                winningLottoRequestDto.getWinningNumbers(),
                winningLottoRequestDto.getBonusNumber()
        );

        LottoResults lottoResults = lottoService.matchWinningLotto(winningLotto);
        outputView.printLottoResult(new LottoResultResponseDto(lottoResults));
    }
}
