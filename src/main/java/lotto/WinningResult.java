package lotto;

import java.util.EnumMap;
import java.util.List;

public class WinningResult {

    private final EnumMap<WinningPrice, Integer> winningResult = new EnumMap<>(WinningPrice.class);

    public EnumMap<WinningPrice, Integer> getWinningResult() {
        return winningResult;
    }

    public WinningResult() {
        init();
    }

    private void init() {
        winningResult.put(WinningPrice.FIVE, 0);
        winningResult.put(WinningPrice.FOUR, 0);
        winningResult.put(WinningPrice.THIRD, 0);
        winningResult.put(WinningPrice.SECOND, 0);
        winningResult.put(WinningPrice.FIRST, 0);
    }

    public void calculateWinningResult(List<Lotto> lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            WinningPrice winningPrice = WinningPrice.of(lotto.countEqualNumbers(winningNumbers), lotto.countEqualBonusNumber(bonusNumber));
            saveWinningResult(winningPrice);
        }
    }

    private void saveWinningResult(WinningPrice winningPrice) {
        if(winningPrice == null)
            return;
        winningResult.put(winningPrice, winningResult.getOrDefault(winningPrice, 0) + 1);
    }

    public Double calculateRateOfReturn(int amount) {
        Double sum = 0.0;
        Double total = 0.0;
        for (WinningPrice winningPrice : WinningPrice.values()) {
            int count = winningResult.get(winningPrice);
            sum += count * winningPrice.getPrice();
        }

        total = sum / amount / 100;
        return total;
    }

}
