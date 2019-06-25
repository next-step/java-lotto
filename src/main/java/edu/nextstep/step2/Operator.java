package edu.nextstep.step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 01:53
 */
public enum Operator {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int match;
    private int lotteryMoney;

    Operator(int match, int lotteryMoney) {
        this.match = match;
        this.lotteryMoney = lotteryMoney;
    }

    public static Operator matchCheck(int operator) {
        Operator[] operatorType = Operator.values();
        return Arrays.stream(operatorType)
                .filter(oper -> oper.match == operator)
                .findFirst()
                .get();
    }

    public static List<Operator> getOperators() {
        return Arrays.stream(Operator.values()).collect(Collectors.toList());
    }

    public int getLotteryMoney() {
        return this.lotteryMoney;
    }

    public int getMatch() {
        return this.match;
    }

}
