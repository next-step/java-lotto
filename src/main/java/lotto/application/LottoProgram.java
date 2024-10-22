package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoProgram {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoProgram(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos generateLottos(int lottoQuantityWithoutManual, List<String[]> manualLottosInput) {
        Lottos totalLottos = this.generateLottos(lottoQuantityWithoutManual);

        if (!manualLottosInput.isEmpty()) {
            return Lottos.from(totalLottos, this.generateManualLottos(manualLottosInput));
        }

        return totalLottos;
    }

    private Lottos generateManualLottos(List<String[]> manualLottosInput) {
        return new Lottos(manualLottosInput.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    private Lottos generateLottos(int lottoQuantity) {
        return lottoNumberGenerator.generate(lottoQuantity);
    }

    public LottoWinningStatistics createWinningStatistics(Lottos userLottos,
                                                          String[] winningLottoNumbersInput, int bonusLottoNumber) {
        return new LottoWinningStatistics(
                userLottos,
                new WinningLotto(winningLottoNumbersInput, bonusLottoNumber));
    }
}
