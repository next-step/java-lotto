package lotto.domain;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private static final int MIN_MATCH_COUNT = 0;
    private static final int MAX_MATCH_COUNT = 6;
    private static final Map<Integer, LottoRank> BY_LOTTO_RANK = Stream.of(values())
            .collect(Collectors.toMap(rank -> rank.matchCount, Function.identity()));

    private final int matchCount;
    private final int winningMoney;

    public int matchCount() {
        return this.matchCount;
    }

    public int winningMoney() {
        return this.winningMoney;
    }

    LottoRank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOfMatchCount(int matchCount) {
        validateMatchCount(matchCount);
        return Optional.ofNullable(BY_LOTTO_RANK.get(matchCount)).orElse(MISS);
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount > MAX_MATCH_COUNT || matchCount < MIN_MATCH_COUNT) {
            throw new IllegalArgumentException(String.format("일치하는 로또 갯수가 0에서 6을 벗어날 수 없습니다. (현재 찾고자 하는 로또 갯수 : %d)", matchCount));
        }
    }
}
