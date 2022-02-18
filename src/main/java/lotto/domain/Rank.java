package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0,0);

    private final int grade;
    private final int money;

    Rank(int grade, int money) {
        this.grade = grade;
        this.money = money;
    }

    public static Rank getRank(int numberOfMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.grade == numberOfMatch)
            .findFirst()
            .orElse(NONE);
    }

    public static int getCount(LottoStatistics lottoStatistics, int matchCount) {
        return lottoStatistics.getLottoStatistics().stream()
            .filter(lottoStatistic -> lottoStatistic.grade == matchCount)
            .collect(Collectors.toList())
            .size();
    }


    public int getGrade() {
        return grade;
    }

    public int getMoney() {
        return money;
    }
}
