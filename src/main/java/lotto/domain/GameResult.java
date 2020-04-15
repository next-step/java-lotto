package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private Map<Prize, Integer> result;
    private List<Lotto> purchasedLottos;
    private WinningLotto winningLotto;

    public GameResult() {
        initialize();
    }

    public GameResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        initialize();
        this.purchasedLottos = new ArrayList<>(purchasedLottos);
        this.winningLotto = winningLotto;
    }

    private void initialize() {
        result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public void addWinResult(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public Integer getWinResult(Prize prize) {
        return result.get(prize);
    }

    public double getProfit(Money purchaseAmount) {
        return (double) getTotalPrizeAmount() / (double) purchaseAmount.getAmount();
    }

    private long getTotalPrizeAmount() {
        return result.keySet().stream()
                .mapToInt(this::getTotal)
                .sum();
    }

    public GameResult getResult() {
        GameResult gameResult = new GameResult(this.purchasedLottos, this.winningLotto);
        for (Lotto lotto : this.purchasedLottos) {
            gameResult.addWinResult(this.winningLotto.match(lotto));
        }
        return gameResult;
    }

    private int getTotal(Prize prize) {
        return result.get(prize) * prize.getAmount();
    }
}
