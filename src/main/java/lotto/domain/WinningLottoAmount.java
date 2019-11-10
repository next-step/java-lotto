package lotto.domain;

import java.util.*;

public enum WinningLottoAmount {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    FIRST(6, 2000000000),
    LOSING_TICKET(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int matchCount;
    private long amount;

    WinningLottoAmount(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static WinningLottoAmount findWinningAmount(long matchCount) {
        return Arrays.stream(values())
                .filter(lottoWinningAmount -> lottoWinningAmount.matchCount >= WINNING_MIN_COUNT && lottoWinningAmount.matchCount == matchCount)
                .findFirst()
                .orElse(LOSING_TICKET);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }

    public static Long totalAmount(List<WinningLottoAmount> winningLottoAmount) {
        return winningLottoAmount.stream()
                .map(winningAmount -> winningAmount.amount)
                .reduce(0L, Long::sum);
    }

    public static Map<WinningLottoAmount, Long> lottoResult(List<WinningLottoAmount> winningLottoAmount) {
        Map<WinningLottoAmount, Long> lottoResult = new LinkedHashMap<>();
        Arrays.stream(WinningLottoAmount.values()).filter(winningAmount -> winningAmount.amount >= WINNING_MIN_COUNT).forEach(winningAmount -> {
            long cnt = winningLottoAmount.stream()
                    .filter(amount -> amount.isEqualMatchCount(winningAmount.matchCount))
                    .count();

            lottoResult.put(winningAmount, cnt);
        });

        return lottoResult;
    }

    public boolean isEqualMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
