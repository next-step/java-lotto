package kr.insup.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    First(6, 2000),
    Second(5, 300),
    Third(5, 150),
    Fourth(4, 50),
    Fifth(3, 5),
    None(0, 0);

    private final int match;
    private final int winnings;

    LottoPrize(int match, int winnings) {
        this.match = match;
        this.winnings = winnings;
    }

    public static LottoPrize matchLottoPrize(int match, boolean isBonusBallMatch) {
        if (match == First.match()) {
            return First;
        }

        if (match == Second.match() && isBonusBallMatch) {
            return Second;
        }

        if (match == Third.match()) {
            return Third;
        }

        if (match == Fourth.match()) {
            return Fourth;
        }

        if (match == Fifth.match()) {
            return Fifth;
        }

        return None;
    }

    public int winnings() {
        return winnings;
    }

    public int match() {
        return match;
    }
}
