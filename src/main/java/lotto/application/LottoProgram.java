package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProgram {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoProgram(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int lottoQuantityWithoutManual, List<String[]> manualLottosInput) {
        List<Lotto> totalLottos = new ArrayList<>();
        if (!manualLottosInput.isEmpty()) {
            totalLottos.addAll(this.generateManualLottos(manualLottosInput));
        }

        totalLottos.addAll(this.generateLottos(lottoQuantityWithoutManual));
        return totalLottos;
    }

    private List<Lotto> generateManualLottos(List<String[]> manualLottosInput) {
        return manualLottosInput.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateLottos(int lottoQuantity) {
        return lottoNumberGenerator.generate(lottoQuantity);
    }

    public LottoWinningStatistics createWinningStatistics(List<Lotto> userLotto,
                                                          String[] winningLottoNumbersInput, int bonusBall) {
        return new LottoWinningStatistics(
                userLotto,
                new WinningLotto(new Lotto(winningLottoNumbersInput), new LottoNumber(bonusBall)));
    }
}
