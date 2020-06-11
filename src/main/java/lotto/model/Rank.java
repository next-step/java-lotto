package lotto.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonus;

    private Rank(int countOfMatch, int winningMoney, boolean bonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonus = bonus;
    }

    private static Map<RewardStatus, Rank> RANKS = Collections
                                                            .unmodifiableMap(Stream.of(values())
                                                            .collect(Collectors.toMap(Rank::getRewardStatus, Function.identity())));

    public static Rank find(RewardStatus rewardStatus) {
        return Optional.ofNullable(RANKS.get(rewardStatus)).orElse(MISS);
    }

    public RewardStatus getRewardStatus() {
        return new RewardStatus(countOfMatch, bonus);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static Rank getRankByMatchInfo(RewardStatus rewardStatus) {
        if(rewardStatus.getMatchingCount() == 5) {
            return findSecondRank(rewardStatus.isMatchingBonus());
        }

        return Arrays.stream(Rank.values())
                .filter(e -> e.getCountOfMatch() == rewardStatus.getMatchingCount())
                .findFirst()
                .orElse(MISS);
    }

    private static Rank findSecondRank(boolean matchBonus) {
        return (matchBonus) ? Rank.SECOND : Rank.THIRD;
    }

}
