package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(Count.of(6), BigDecimal.valueOf(2_000_000_000)),
    SECOND(Count.of(5), BigDecimal.valueOf(1_500_000)),
    THIRD(Count.of(4), BigDecimal.valueOf(50_000)),
    FOURTH(Count.of(3), BigDecimal.valueOf(5_000)),
    MISS(Count.ZERO, BigDecimal.valueOf(0));

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

    private static final Map<Count, Rank> ranks =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Rank::getCountOfMatch, Function.identity())));

    public static Rank valueOf(Count countOfMatch){
        return Optional.ofNullable(ranks.get(countOfMatch)).orElse(MISS);
    }

//    private Rank valueOf(int countOfMatch){
//        return Arrays.stream(values())
//                .filter(v-> countOfMatch == v.getCountOfMatch())
//                .findFirst()
//                .orElseThrow(()-> new IllegalArgumentException("Invalid matching count"));
//    }
}