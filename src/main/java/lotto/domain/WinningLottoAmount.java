package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum WinningLottoAmount {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    LOSING_TICKET(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int matchCount;
    private long amount;

    WinningLottoAmount(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static WinningLottoAmount findWinningAmount(long matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoWinningAmount -> lottoWinningAmount.matchCount == matchCount)
                .map(lottoWinningAmount -> checkSecond(lottoWinningAmount, matchBonus))
                .findFirst()
                .orElse(LOSING_TICKET);
    }

    private static WinningLottoAmount checkSecond(WinningLottoAmount lottoWinningAmount, boolean matchBonus) {
        if (lottoWinningAmount.matchCount == SECOND.matchCount && matchBonus) {
            return WinningLottoAmount.SECOND;
        }
        return lottoWinningAmount;
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
                    .filter(amount -> amount == winningAmount)
                    .count();

            lottoResult.put(winningAmount, cnt);
        });

        return lottoResult;
    }

    public boolean isEqualMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
