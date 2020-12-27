package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningLottoType {
    MATCH_ZERO("꽝", 0, 0, false),
    MATCH_THREE("3개 일치", 3, 5000, false),
    MATCH_FOUR("4개 일치", 4, 50000, false),
    MATCH_FIVE("5개 일치", 5, 1500000, false),
    MATCH_FIVE_BONUS("5개 일치,보너스 볼 일치", 5, 30000000, true),
    MATCH_SIX("6개 일치", 6, 2000000000, false);
    int matchCount;
    long winnerMoney;
    String name;
    boolean isBonusNumber;

    WinningLottoType( String name, int matchCount, long winnerMoney, boolean isBonusNumber){
        this.name = name;
        this.matchCount = matchCount;
        this.winnerMoney = winnerMoney;
        this.isBonusNumber = isBonusNumber;
    }

    public static WinningLottoType valueOf(int matchCount, boolean isBonusNumber) {
        Predicate<WinningLottoType> filterMatchType = (type)-> type.matchCount == matchCount && type.isBonusNumber==isBonusNumber;
        return Arrays.stream(values())
                .filter( filterMatchType).findFirst().orElseThrow( ()-> new IllegalArgumentException("일치하는 타입이 없습니다."));
    }

    public long getWinnerMoney() {
        return winnerMoney;
    }

    public String getName() {
        return name;
    }

}
