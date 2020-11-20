package step2.constant;

import java.util.Arrays;

public enum LottoWinningPrizes {
    SIX_MATCHES(6, 2_000_000_000),
    FIVE_MATCHES(5, 1_500_000),
    FOUR_MATCHES(4, 50_000),
    THIRD_MATCHES(3, 5_000);

    private int match;
    private long amount;

    private static int winningAmount = 0;

    LottoWinningPrizes(final int match, final long amount) {
        this.match = match;
        this.amount = amount;
    }

    public int getMatch() {
        return match;
    }

    public long getAmount() {
        return amount;
    }

    public static void resultLottoWinning(int rightNumberCount) {
        Arrays.stream(values())
                .filter(lottoWinningPrizes -> lottoWinningPrizes.getMatch() == rightNumberCount)
                .forEach(lottoWinningPrizes -> winningAmount += lottoWinningPrizes.getAmount());
    }

    public static int getWinningAmount() {
        return winningAmount;
    }
}
