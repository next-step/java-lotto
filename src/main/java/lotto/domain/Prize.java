package lotto.domain;

import org.apache.commons.lang3.StringUtils;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, "보너스 볼 일치"),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private int countOfMatch;
    private long money;
    private String memo;

    Prize(int countOfMatch, int money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    Prize(int countOfMatch, long money, String memo) {
        this.countOfMatch = countOfMatch;
        this.money = money;
        this.memo = memo;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getMoney() {
        return money;
    }

    public static Prize valueOf(int matchingCount) {
        for (Prize prize : Prize.values()) {
            if (prize.countOfMatch == matchingCount) {
                return prize;
            }
        }

        throw new IllegalArgumentException("NOT EXISTS");
    }

    @Override
    public String toString() {
        String output = String.format("%d개 일치(%d원)", countOfMatch, money);

        if (StringUtils.isNotEmpty(memo)) {
            output = output.join(", ", output, memo);
        }

        return output;
    }
}
