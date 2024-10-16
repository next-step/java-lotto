package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.Lotto;

import java.util.List;

public class LottoProgram {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoProgram(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int lottoQuantity) {
        return lottoNumberGenerator.generate(lottoQuantity);
    }

    public LottoWinningStatistics createWinningStatistics(List<Lotto> userLotto, String[] winningLottoNumbersInput) {
        return new LottoWinningStatistics(userLotto, new Lotto(winningLottoNumbersInput));
    }

}
