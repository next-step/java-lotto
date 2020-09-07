package lotto.domain;

import java.math.BigDecimal;

public enum Rank {
    FIRST(Count.of(6), BigDecimal.valueOf(2_000_000_000)),
    SECOND(Count.of(5), BigDecimal.valueOf(30_000_000)),
    THIRD(Count.of(5), BigDecimal.valueOf(1_500_000)),
    FOURTH(Count.of(4), BigDecimal.valueOf(50_000)),
    FIFTH(Count.of(3), BigDecimal.valueOf(5_000)),
    MISS(Count.ZERO, BigDecimal.valueOf(0));

    private static final Count MIN_WINNING_COUNT = Count.of(3);
//
//    private static final Map<Count, Rank> RANKS =
//            Collections.unmodifiableMap(Stream.of(values())
//                    .collect(Collectors.toMap(Rank::getCountOfMatch, Function.identity())));

    private Count countOfMatch;
    private BigDecimal winningMoney;

    private Rank(Count countOfMatch, BigDecimal winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public Count getCountOfMatch() {
        return countOfMatch;
    }

    public BigDecimal getWinningMoney() {
        return winningMoney;
    }

    private static Rank valueOf(Count countOfMatch) {
        for (Rank rank : values()) {
            if(isMinWinningCount(countOfMatch)){
                return MISS;
            }

            if (rank.getCountOfMatch().equals(countOfMatch)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Invalid match count");
    }

    public static Rank valueOf(Count countOfMatch, boolean matchBouns){
        Rank rank = valueOf(countOfMatch);

        if(rank == SECOND && !matchBouns){
            rank = THIRD;
        }

        return rank;
    }

    private static boolean isMinWinningCount(Count count){
        return count.compareTo(MIN_WINNING_COUNT) < 0;
    }
}