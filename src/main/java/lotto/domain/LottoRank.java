package lotto.domain;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, Money.won(2_000_000_000), (count, matchBonus) -> count == 6),
    SECOND(5, Money.won(30_000_000), (count, matchBonus) -> count == 5 && matchBonus),
    THIRD(5, Money.won(1_500_000), (count, matchBonus) -> count == 5 && !matchBonus),
    FOURTH(4, Money.won(50_000), (count, matchBonus) -> count == 4),
    FIFTH(3, Money.won(5_000), (count, matchBonus) -> count == 3),
    MISS(0, Money.ZERO, (count, matchBonus) -> count < 3);

    private final int countOfMatch;
    private final Money prizeMoney;
    private final BiPredicate<Integer, Boolean> biPredicate;

    LottoRank(int countOfMatch, Money prizeMoney, BiPredicate<Integer, Boolean> biPredicate) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.biPredicate = biPredicate;
    }

    public static LottoRank of(int countOfMatch, boolean matchBonus) {
        if (countOfMatch > FIRST.countOfMatch || countOfMatch < MISS.countOfMatch) {
            throw new IllegalArgumentException("일치 숫자는 0이상 6이하 이어야 한다.");
        }

        return Stream.of(values())
                .filter(lottoRank -> lottoRank.biPredicate.test(countOfMatch, matchBonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("등수를 매길 수 없습니다."));
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money calculatePrizeMoney(int prizeCount) {
        return prizeMoney.times(prizeCount);
    }
}
