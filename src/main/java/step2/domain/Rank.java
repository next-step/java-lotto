package step2.domain;

import step2.exception.IllegalLottoResultCount;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6,2_000_000_000),
    BONUS(5, 30_000_000);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }
    
//
//    public static Rank of(int matchCount) {
//        return Arrays.stream(values())
//                .filter(priceEnum -> priceEnum.countOfMatch == matchCount)
//                .findFirst()
//                .orElseThrow(() -> new IllegalLottoResultCount("잘못된 입력값입니다."));
//    }
//
//    public int getRewardCash() {
//        return matchResultsMessage.get();
//    }

}
