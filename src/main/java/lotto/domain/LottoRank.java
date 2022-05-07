package lotto.domain;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private static final int MIN_MATCH_COUNT = 0;
    private static final int FIVE_MATCH_COUNT = 5;
    private static final int MAX_MATCH_COUNT = 6;
    private static final Map<Integer, LottoRank> BY_LOTTO_RANK = Stream.of(values())
            .filter(lottoRank -> !lottoRank.matchBonus)
            .collect(Collectors.toMap(rank -> rank.matchCount, Function.identity()));

    private final int matchCount;
    private final int winningMoney;
    private final boolean matchBonus;

    public int matchCount() {
        return this.matchCount;
    }

    public int winningMoney() {
        return this.winningMoney;
    }

    LottoRank(int matchCount, int winningMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public static LottoRank findLottoRank(int matchCount, boolean matchBonus) {
        validateMatchCount(matchCount);
        if (isSecondRank(matchCount, matchBonus)) {
            return LottoRank.SECOND;
        }
        return Optional.ofNullable(BY_LOTTO_RANK.get(matchCount)).orElse(MISS);
    }

    private static boolean isSecondRank(int matchCount, boolean matchBonus) {
        return matchCount == FIVE_MATCH_COUNT && matchBonus;
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount > MAX_MATCH_COUNT || matchCount < MIN_MATCH_COUNT) {
            throw new IllegalArgumentException(String.format("일치하는 로또 갯수가 0에서 6을 벗어날 수 없습니다. (현재 찾고자 하는 로또 갯수 : %d)", matchCount));
        }
    }
}
