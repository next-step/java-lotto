package lotto;

import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;

public class LottoController {

    private final LottoService lottoService;
    private Money money;
    private Lottos lottos;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoStatusResponseDto buyLotto(MoneyRequestDto moneyRequestDto) {
        money = new Money(moneyRequestDto.getMoney());
        lottos = lottoService.buyLotto(money);
        return new LottoStatusResponseDto(lottos);
    }

    public LottoResultResponseDto drawWinningLotto(WinningNumbersRequestDto winningNumbersRequestDto) {
        WinningNumbers winningNumbers = new WinningNumbers(
                winningNumbersRequestDto.getWinningNumbers(),
                winningNumbersRequestDto.getBonusNumber()
        );
        LottoResults lottoResults = lottoService.matchWinningLotto(lottos, winningNumbers);
        double profit = lottoService.profitRate(lottoResults, money);

        return new LottoResultResponseDto(lottoResults, profit);
    }
}
