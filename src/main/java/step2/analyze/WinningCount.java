package step2.analyze;

import step2.game.Ticket;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningCount {
    private static final int SINGLE_COUNT = 1;

    private Map<Prize, Integer> winningCount;

    public WinningCount() {
        winningCount = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            winningCount.put(prize, 0);
        }
    }

    public Map<Prize, Integer> getWinningCount() {
        return winningCount;
    }

    public void addCount(Prize prize) {
        int count = winningCount.get(prize);
        winningCount.put(prize, count + SINGLE_COUNT);
    }

    public int countOfPrize(Prize prize) {
        return winningCount.getOrDefault(prize, 0);
    }

    public float calculateWinningRate() {
        return calculateTotalEarningMoney() / calculateTicketPrice();
    }

    private float calculateTotalEarningMoney() {
        return winningCount.keySet().stream()
                .map(prize -> prize.calculateEarningMoney(winningCount.get(prize)))
                .reduce((o1, o2) -> o1 + o2)
                .orElseThrow(IllegalArgumentException::new);
    }

    private int calculateTicketPrice() {
        return winningCount.values().stream()
                .reduce((o1, o2) -> o1 + o2).orElse(0) * Ticket.LOTTO_PRICE;
    }
}
