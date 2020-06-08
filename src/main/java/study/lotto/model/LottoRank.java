package study.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST_RANK(6, 2_000_000_000),
    SECOND_RANK(5, 30_000_000),
    THIRD_RANK(5, 1_500_000),
    FORTH_RANK(4, 50_000),
    FIFTH_RANK(3, 5_000),
    NO_RANK(0, 0);

    private static final int MAXIMUM_PRIZE_MATCHES = 6;
    private static final int SECOND_PRIZE_MATCHES = 5;
    private static final int MINIMUM_PRIZE_MATCHES = 3;
    private static final int NO_PRIZE_MATCHES = 0;

    private static final Map<Integer, LottoRank> BY_MATCHES;

    private final int matches;
    private final int prize;

    static {
        BY_MATCHES = Arrays.stream(values())
                .filter(lottoRank -> !lottoRank.equals(SECOND_RANK))
                .collect(Collectors.toMap(o -> o.matches, Function.identity()));
    }

    LottoRank(int matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }

    private static void validateMatchCount(int matches) {
        if((matches < NO_PRIZE_MATCHES) || (matches > MAXIMUM_PRIZE_MATCHES)) {
            throw new IllegalArgumentException("matches는 0~6사이의 값 이어야 합니다.");
        }
    }

    public static LottoRank find(int matches, boolean matchBonus) {
        validateMatchCount(matches);

        if((matches >= (SECOND_PRIZE_MATCHES-1)) && matchBonus) {
            return SECOND_RANK;
        }

        return BY_MATCHES.getOrDefault(matches, LottoRank.NO_RANK);
    }

    public static List<LottoRank> getLottoRanksOverMinimumMatches() {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatches() >= MINIMUM_PRIZE_MATCHES)
                .collect(Collectors.toList());
    }

    public int getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }
}
