package study.lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST_RANK(6, 2000000000),
    SECOND_RANK(5, 1500000),
    THIRD_RANK(4, 50000),
    FORTH_RANK(3, 5000),
    NO_RANK(0, 0);

    private final int matches;
    private final int prize;

    private static final int MINIMUM_MATCHES = 3;
    private static final int NO_PRIZE_MATCHES = 0;
    private static final Map<Integer, LottoRank> BY_MATCHES;

    static {
        BY_MATCHES = Arrays.stream(values()).collect(Collectors.toMap(o -> o.matches, Function.identity()));
    }

    LottoRank(int matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }

    public static LottoRank find(int matches) {
        if(matches < MINIMUM_MATCHES) {
            matches = NO_PRIZE_MATCHES;
        }

        return Optional.ofNullable(BY_MATCHES.get(matches)).orElseThrow(IllegalArgumentException::new);
    }

    public int getPrize() {
        return prize;
    }

    public boolean isPrizeExists() {
        return matches >= MINIMUM_MATCHES;
    }

    @Override
    public String toString() {
        return matches + "개 일치 (" + prize + "원)";
    }
}
