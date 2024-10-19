package lottogame.domain;

import lottogame.domain.lotto.*;
import lottogame.domain.strategy.PredefinedLottoNumberStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameService {
    private final LottoPurchase lottoPurchase;
    private final Lottos lottos;

    public LottoGameService(int buyAmount, int manualLottoCount, List<String> manualLottoNumbers) {
        this.lottoPurchase = new LottoPurchase(buyAmount, manualLottoCount);
        this.lottos = createLottos(manualLottoNumbers);
    }

    private Lottos createLottos(List<String> manualLottoNumbers) {
        Lottos manualLottos = createManualLottos(manualLottoNumbers);
        Lottos autoLottos = createAutoLottos(lottoPurchase.getAutoCount());

        return Lottos.merge(manualLottos, autoLottos);
    }

    public WinningLotto createWinningLotto(String winningNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(new PredefinedLottoNumberStrategy(winningNumbers));
        LottoNumber bonus = new LottoNumber(bonusNumber);

        return new WinningLotto(winningLotto, bonus);
    }

    private Lottos createAutoLottos(int count) {
        return new Lottos(count);
    }

    private Lottos createManualLottos(List<String> manualLottoNumbers) {
        return new Lottos(manualLottoNumbers.stream()
                .map(numbers -> new Lotto(new PredefinedLottoNumberStrategy(numbers)))
                .collect(Collectors.toList()));
    }

    public Map<Rank, Integer> calculateWinningResults(WinningLotto winningLotto) {
        return lottos.calculateWinningStatistics(winningLotto);
    }

    public double calculatePrizeRate(WinningLotto winningLotto) {
        double totalPrizeAmount = lottos.calculateTotalPrizeAmount(winningLotto);

        return totalPrizeAmount / lottoPurchase.getTotalAmount();
    }

    public LottoPurchase getLottoPurchase() {
        return lottoPurchase;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
