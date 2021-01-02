package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningLottoType {
    MATCH_ZERO("꽝", 0, 0),
    MATCH_THREE("3개 일치", 3, 5000),
    MATCH_FOUR("4개 일치", 4, 50000),
    MATCH_FIVE("5개 일치", 5, 1500000),
    MATCH_FIVE_BONUS("5개 일치,보너스 볼 일치", 5, 30000000),
    MATCH_SIX("6개 일치", 6, 2000000000);
    int matchCount;
    long winnerMoney;
    String name;

    WinningLottoType( String name, int matchCount, long winnerMoney){
        this.name = name;
        this.matchCount = matchCount;
        this.winnerMoney = winnerMoney;
    }

    public static WinningLottoType valueOf(int matchCount, boolean isBonusNumber) {
        if (matchCount < 3) return MATCH_ZERO;
        if (matchCount == MATCH_FIVE_BONUS.matchCount) {
            return isBonusNumber? MATCH_FIVE_BONUS : MATCH_FIVE;
        }
        Predicate<WinningLottoType> filterMatchType = (type)-> type.matchCount == matchCount;
        return Arrays.stream(values())
                .filter( filterMatchType)
                .findFirst()
                .orElseThrow( ()-> new IllegalArgumentException("일치하는 타입이 없습니다."));
    }

    public long getWinnerMoney() {
        return winnerMoney;
    }

    public String getName() {
        return name;
    }

}
