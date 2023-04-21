package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.dto.LottoNumbersDto;
import lotto.dto.WinningStatDto;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final Amount amount;
    private final LottoList lottoList;
    private Lotto winningLotto;

    public LottoMachine(int amount, LottoStrategy lottoStrategy) {
        this.amount = new Amount(amount);
        this.lottoList = new LottoList(this.amount.calculateUnitCount(LOTTO_PRICE), lottoStrategy);
    }

    public int countNumberOfLottoTickets() {
        return this.amount.calculateUnitCount(LOTTO_PRICE);
    }

    public LottoNumbersDto lottoNumbersDto() {
        return this.lottoList.lottoNumbersDto();
    }

    public void conclusionWinningNumbers(String winningNumbers) {
        this.winningLotto = Lotto.winningLotto(winningNumbers);
    }

    public WinningStatDto winningStat() {
        final WinningStatDto winningStatDto = this.lottoList.rating(winningLotto);
        winningStatDto.setRateOfReturn(this.amount);

        return winningStatDto;
    }
}
