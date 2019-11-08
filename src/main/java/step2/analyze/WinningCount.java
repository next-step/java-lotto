package step2.analyze;

import step2.game.Ticket;

import java.util.Map;

public class WinningCount {
    public static final int MIN_MATCH_COUNT = 3;
    public static final int MAX_MATCH_COUNT = 6;

    private Map<Prize, Integer> winningCount;

    public WinningCount(Map<Prize, Integer> winningCount) {
        this.winningCount = winningCount;
    }

    public int countOfMatchCount(int matchCount) {
        return winningCount.getOrDefault(Prize.ofMatchCount(matchCount), 0);
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
