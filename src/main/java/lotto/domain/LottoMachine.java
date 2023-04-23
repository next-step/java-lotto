package lotto.domain;

import lotto.dto.LottoNumbersDto;
import lotto.dto.WinningStatDto;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public int calculateUnitCount(Amount amount) {
        return amount.calculateUnitCount(LOTTO_PRICE);
    }

    public LottoNumbersDto lottoNumbersDto(Lottos lottos) {
        return lottos.lottoNumbersDto();
    }

    public Lotto winningLotto(String winningNumbers) {
        return Lotto.winningLotto(winningNumbers);
    }

    public WinningStatDto winningStat(Lottos lottos, Lotto winningLotto, Amount amount) {
        final WinningStatDto winningStatDto = lottos.rating(winningLotto);
        winningStatDto.setRateOfReturn(amount);

        return winningStatDto;
    }
}
