package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void countWinningResults(Lotto winningNumbers, LottoNumber bonusNumber, WinningResult winningResult) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean existenceOfBonusNumber = lotto.contains(bonusNumber);
            winningResult.addNumberOfWinning(numberOfWinningNumbers, existenceOfBonusNumber);
        }
    }

    public float calculateEarningRate(int earningPrice, int purchasePrice) {
        return (float) earningPrice / (float) purchasePrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
