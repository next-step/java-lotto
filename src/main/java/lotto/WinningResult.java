package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<Integer, Integer> winningResult = new HashMap<>();

    public Map<Integer, Integer> getWinningResult() {
        return winningResult;
    }

    public WinningResult() {
        init();
    }

    private void init() {
        winningResult.put(3, 0);
        winningResult.put(4, 0);
        winningResult.put(5, 0);
        winningResult.put(6, 0);
    }

    public void calculateWinningResult(List<Lotto> lottos, Lotto winningNumbers) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int equalNumberCount = lotto.countEqualNumbers(winningNumbers);
            saveWinningResult(equalNumberCount);
        }

    }

    private void saveWinningResult(int equalNumberCount) {
        if (equalNumberCount >= 6) {
            winningResult.put(6, winningResult.getOrDefault(6, 0) + 1);
        } else if (equalNumberCount >= 5) {
            winningResult.put(5, winningResult.getOrDefault(5, 0) + 1);
        } else if (equalNumberCount >= 4) {
            winningResult.put(4, winningResult.getOrDefault(4, 0) + 1);
        } else if (equalNumberCount >= 3) {
            winningResult.put(3, winningResult.getOrDefault(3, 0) + 1);
        }
    }


    public Double calculateRateOfReturn(int amount) {
        Double sum = 0.0;
        Double total = 0.0;
        for (int i = WinningPrice.getLastEqualCount(); i <= WinningPrice.getFirstEqualCount(); i++) {
            int count = winningResult.get(i);
            sum += count * WinningPrice.of(i).getPrice();
        }

        total = sum / amount / 100;
        return total;
    }

}
