package edu.nextstep.step4.enums;

import edu.nextstep.step4.domain.Lotto;
import edu.nextstep.step4.domain.WinInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    ZERO(0, 0, false),
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private int match;
    private int lotteryMoney;
    private boolean bonusRank;

    Rank(int match, int lotteryMoney, boolean bonusRank) {
        this.match = match;
        this.lotteryMoney = lotteryMoney;
        this.bonusRank = bonusRank;
    }

    public static Rank matchCheck(int rankNumber) {
        Rank[] rankType = Rank.values();
        return Arrays.stream(rankType)
                .filter(rank -> rank.match == rankNumber)
                .filter(rank -> !rank.getBonusRank())
                .findFirst()
                .orElse(Rank.ZERO);
    }

    public static List<Rank> getRanks() {
        return Arrays.stream(Rank.values()).collect(Collectors.toList());
    }

    public static int matchOfCount(WinInfo lotteryInfo, Rank rank) {
        return lotteryInfo.values()
                .filter(value -> value.getMatch() == rank.getMatch())
                .collect(Collectors.toList())
                .size();
    }

    public int getLotteryMoney() {
        return this.lotteryMoney;
    }

    public int getMatch() {
        return this.match;
    }

    public boolean getBonusRank() {
        return this.bonusRank;
    }
}
