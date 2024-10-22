package lotto.dto;

import java.math.BigDecimal;

public class PrizeMoneyDto {
    private final int collectCount;
    private final int count;
    private final boolean matchBonus;
    private final BigDecimal prizeMoney;

    public PrizeMoneyDto(BigDecimal prizeMoney, int count, int collectCount, boolean matchBounus) {
        this.prizeMoney = prizeMoney;
        this.count = count;
        this.collectCount = collectCount;
        this.matchBonus = matchBounus;
    }

    public int getCount() {
        return count;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
