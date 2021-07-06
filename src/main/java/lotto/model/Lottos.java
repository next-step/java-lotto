package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
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
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
