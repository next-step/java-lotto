package lotto.model;

import java.util.Arrays;


public enum MatchedNumber {

    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000)
    ;

    private final Integer count;

    private final Integer money;

    MatchedNumber(Integer money, Integer count) {
        this.count = count;
        this.money = money;
    }

    public static Integer getReward(Integer value){
        return Arrays.stream(MatchedNumber.values()).filter((matchedNumber)->matchedNumber.count == value).map(matchedNumber -> matchedNumber.money).findFirst().orElse(0);
    }
}