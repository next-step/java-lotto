package lotto.model;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> origin/step2

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
<<<<<<< HEAD
        this.lottos = lottos;
    }

    public void countWinningResults(Lotto winningNumbers, int bonusNumber, WinningResult winningResult) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean existenceOfBonusNumber = lotto.contains(bonusNumber);
            winningResult.addNumberOfWinning(numberOfWinningNumbers, existenceOfBonusNumber);
        }
    }

    public float calculateEarningRate(int earningPrice, int purchasePrice) {
        return (float) earningPrice / (float) purchasePrice;
=======
        this.lottos = new ArrayList<>(lottos);
    }

    public WinningResults countWinningResults(WinningLotto winningLotto) {
        Map<WinningResult, Integer> results = new HashMap<>();
        for (WinningResult value : WinningResult.values()) {
            results.put(value, 0);
        }
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = winningLotto.countWinningNumbers(lotto);
            boolean existenceOfBonusNumber = winningLotto.containsBonusNumber(lotto);
            WinningResult winningResult = WinningResult.addNumberOfWinning(numberOfWinningNumbers, existenceOfBonusNumber);
            results.put(winningResult, results.get(winningResult) + 1);
        }
        return new WinningResults(results);
>>>>>>> origin/step2
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
