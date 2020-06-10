package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    MISS(6, 0, 0);

    private int lottoRank;
    private int countOfMatch;
    private int winningMoney;

    private Rank(int lottoRank, int countOfMatch, int winningMoney) {
        this.lottoRank    = lottoRank;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    private static Map<Integer, Rank> rankHash = Collections
                                                            .unmodifiableMap(Stream.of(values())
                                                            .collect(Collectors.toMap(Rank::getLottoRank, Function.identity())));

    public static Rank find(int ranking) {
        return Optional.ofNullable(rankHash.get(ranking)).orElse(MISS);
    }

    public int getLottoRank() {
        return lottoRank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRankByMatchInfo(int countOfMatch, boolean matchBonus) {
        if(countOfMatch == 5) {
            return findSecondRank(matchBonus);
        }

        return Arrays.stream(Rank.values())
                .filter(e -> e.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    private static Rank findSecondRank(boolean matchBonus) {
        return (matchBonus) ? Rank.SECOND : Rank.THIRD;
    }

}
