package lotto.statistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int countOfMatch;
    private final int earn;

    Ranking(int countOfMatch, int earn) {
        this.countOfMatch = countOfMatch;
        this.earn = earn;
    }

    public static Ranking valueOf(int countOfMatch, boolean matchBonus) {
        if (matchBonus && countOfMatch == 5) {
            return Ranking.SECOND;
        }
        if (countOfMatch == 5) {
            return Ranking.THIRD;
        }
        return Arrays.stream(values())
            .filter(value -> value.countOfMatch == countOfMatch)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("match count는 3, 4, 5, 6만 사용이 가능합니다 match count: " + countOfMatch));
    }

    public static List<Ranking> reverse(boolean hasBonus) {
        if (hasBonus) {
            return Arrays.stream(Ranking.values())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        }
        return Arrays.stream(Ranking.values())
            .filter(ranking -> ranking != SECOND)
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
    }

}
