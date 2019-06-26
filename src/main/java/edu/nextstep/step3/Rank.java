package edu.nextstep.step3;

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
public enum Rank {

    ZERO(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int match;
    private int lotteryMoney;

    Rank(int match, int lotteryMoney) {
        this.match = match;
        this.lotteryMoney = lotteryMoney;
    }

    public static Rank matchCheck(int rankNumber) {
        Rank[] rankType = Rank.values();
        return Arrays.stream(rankType)
                .filter(rank -> rank.match == rankNumber)
                .findFirst()
                .orElse(Rank.ZERO);
    }

    public static List<Rank> getRanks() {
        return Arrays.stream(Rank.values()).collect(Collectors.toList());
    }

    public int getLotteryMoney() {
        return this.lotteryMoney;
    }

    public int getMatch() {
        return this.match;
    }

}
