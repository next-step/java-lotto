package domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    First(6, "2,000,000,000"), Second(5, "1,500,000"),
    Third(4, "50,000"), Fourth(3, "5,000"),
    None(-1, "0");

    private Integer matchCount;
    private String prizeMoney;

    Rank(Integer matchCount, String prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank calculate(int matchCount) {
        Optional<Rank> rank = Arrays.stream(Rank.values())
            .filter(r -> r.matchCount == matchCount)
            .findFirst();

        return rank.orElse(None);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return Long.parseLong(prizeMoney.replace(",", ""));
    }

    public String getPrizeMoneyForDisplay() {
        return prizeMoney;
    }
}
