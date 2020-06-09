package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public enum WinnerTier {
    MATCH_SIX(2_000_000_000, 6),
    MATCH_FIVE(1_500_000, 5),
    MATCH_FOUR(50_000, 4),
    MATCH_THREE(5_000, 3),
    MISS(0, 0);

    public static final List<WinnerTier> WINNINGS = Arrays.asList(MATCH_THREE, MATCH_FOUR, MATCH_FIVE, MATCH_SIX);

    private final long prize;
    private final long matchCnt;

    WinnerTier(long prize, long matchCnt) {
        this.prize = prize;
        this.matchCnt = matchCnt;
    }

    public long getPrize() {
        return prize;
    }

    public long getMatchCnt() {
        return matchCnt;
    }

    public boolean equalMatchCnt(long matchCnt) {
        return this.matchCnt == matchCnt;
    }

    public static Stream<WinnerTier> stream() {
        return Stream.of(MATCH_THREE, MATCH_FOUR, MATCH_FIVE, MATCH_SIX);
    }

    public static WinnerTier valueOf(long matchCnt) {
        return stream().filter(rank -> rank.equalMatchCnt(matchCnt))
                .findFirst()
                .orElse(MISS);
    }

    public static double returnYield(int lottoMoney, Map<WinnerTier, Integer> winningResult) {
        double sum = 0;

        for (WinnerTier winnerTier : WinnerTier.values()) {
            sum += winnerTier.getPrize() * winningResult.get(winnerTier);
        }

        return Math.floor(sum / lottoMoney * 100) / 100;
    }
}
