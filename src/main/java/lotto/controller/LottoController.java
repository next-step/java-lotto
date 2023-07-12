package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.service.LottoService;

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
        validateNullSafe();
        WinningNumbers winningNumbers = new WinningNumbers(
                winningNumbersRequestDto.getWinningNumbers(),
                winningNumbersRequestDto.getBonusNumber()
        );
        LottoResults lottoResults = lottoService.matchWinningLotto(lottos, winningNumbers);
        double profit = lottoService.profitRate(lottoResults, money);

        return new LottoResultResponseDto(lottoResults, profit);
    }

    private void validateNullSafe() {
        if (money == null || lottos == null) {
            throw new IllegalStateException("로또를 먼저 구매해야 합니다.");
        }
    }
}
