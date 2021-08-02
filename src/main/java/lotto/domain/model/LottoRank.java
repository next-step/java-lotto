package lotto.domain.model;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final Map<Integer, LottoRank> countToRank = Stream.of(values())
            .collect(toMap(LottoRank::getCountOfMatch, e -> e));

    private int countOfMatch;
    private int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch) {
        if (countOfMatch < FIFTH.countOfMatch) {
            return MISS;
        }
        return countToRank.get(countOfMatch);
    }

    public static List<LottoRank> getPrintableValues() {
        List<LottoRank> values = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getCountOfMatch() >= FIFTH.getCountOfMatch())
                .collect(Collectors.toList());
        Collections.reverse(values);
        return values;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
