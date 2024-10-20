package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoProgram {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoProgram(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int lottoQuantity) {
        return lottoNumberGenerator.generate(lottoQuantity);
    }

    public LottoWinningStatistics createWinningStatistics(List<Lotto> userLotto,
                                                          String[] winningLottoNumbersInput, int bonusBall) {
        return new LottoWinningStatistics(userLotto, new WinningLotto(new Lotto(winningLottoNumbersInput), new LottoNumber(bonusBall)));
    }

}
