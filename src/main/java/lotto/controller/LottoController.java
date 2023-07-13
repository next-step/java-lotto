package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.LottoStatusResponseDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningLottoRequestDto;
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

    public LottoResultResponseDto drawWinningLotto(WinningLottoRequestDto winningLottoRequestDto) {
        validateNullSafe();
        WinningLotto winningLotto = new WinningLotto(
                winningLottoRequestDto.getWinningNumbers(),
                winningLottoRequestDto.getBonusNumber()
        );
        LottoResults lottoResults = lottoService.matchWinningLotto(lottos, winningLotto);
        double profit = lottoService.profitRate(lottoResults, money);

        return new LottoResultResponseDto(lottoResults, profit);
    }

    private void validateNullSafe() {
        if (money == null || lottos == null) {
            throw new IllegalStateException("로또를 먼저 구매해야 합니다.");
        }
    }
}
