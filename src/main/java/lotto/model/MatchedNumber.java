package lotto.model;

import java.util.Arrays;

/**
 * Created by P-161 at : 2022-09-27
 *
 * 여기에 MatchedNumber 열거형에 대한 설명을 기술해주세요
 *
 * @author P-161
 * @version 1.0
 * @since 1.0
 */
public enum MatchedNumber {

    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000)
    ;

    private final Integer money;

    private final Integer count;

    MatchedNumber(Integer money, Integer count) {
        this.money = money;
        this.count = count;
    }

    public static Integer getReward(Integer value){
        return Arrays.stream(MatchedNumber.values()).filter((matchedNumber)->matchedNumber.count == value).map(matchedNumber -> matchedNumber.money).findFirst().orElse(0);
    }
}