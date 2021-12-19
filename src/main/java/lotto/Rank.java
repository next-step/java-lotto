package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2000000000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L),
    MISS(-1, 0)
    ;

    private final int numberOfMatch;
    private final Money winPrice;

    Rank(int numberOfMatch, long winPrice) {
        this.numberOfMatch = numberOfMatch;
        this.winPrice = new Money(winPrice);
    }

    public static final List<Rank> LOTTO_WINS_NOT_BONUS = Stream.of(FIFTH, FOURTH, THIRD, FIRST)
            .collect(Collectors.toList());

    public static final List<Rank> LOTTO_WINS = Stream.of(FIFTH, FOURTH, THIRD, SECOND, FIRST)
            .collect(Collectors.toList());

    public static Rank of(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }

        return LOTTO_WINS_NOT_BONUS.stream()
                .filter(lottoWin -> lottoWin.numberOfMatch == matchCount)
                .findFirst()
                .orElse(MISS)
                ;
    }

    public int numberOfMatch() {
        return this.numberOfMatch;
    }

    public Money winPrice() {
        return this.winPrice;
    }

}
