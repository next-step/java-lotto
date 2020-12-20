package step2.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private long countOfMatch;
    private int winningMoney;

    // 새로운 인스턴스를 생성하지 않도록 캐싱 전략 적용
    private static final List<Rank> RANKS_WITHOUT_THIRD = new ArrayList<>(asList(FIRST, SECOND, FOURTH, FIFTH));
    private static final List<Rank> RANKS_WITHOUT_SECOND = new ArrayList<>(asList(FIRST, THIRD, FOURTH, FIFTH));

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRank(long countOfMatch, boolean answerOfIncludedBonusNumber) {
        return getRanksByBonusNumber(answerOfIncludedBonusNumber).stream()
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS); // Optional 이용
    }

    private static List<Rank> getRanksByBonusNumber(boolean answerOfIncludedBonusNumber) {
        if (answerOfIncludedBonusNumber) {
            return RANKS_WITHOUT_THIRD; // 보너스 숫자를 가졌으면, 번호 5개일치 상황때 2등이 된다
        }
        return RANKS_WITHOUT_SECOND; // 보너스 숫자를 안 가졌으면, 번호 5개일치 상황때 3등이 된다
    }
}
