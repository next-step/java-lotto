package lotto.dto;

import lotto.entity.PrizeMoney;

import java.math.BigDecimal;

public class RankDto {

    private final int collectCount;
    private final BigDecimal money;

    private int count = 0;

    public RankDto(PrizeMoney prizeMoney) {
        this(prizeMoney.getCount(), prizeMoney.getPrizeMoney());
    }

    public RankDto(int collectCount, BigDecimal prizeMoney) {
        this.collectCount = collectCount;
        this.money = prizeMoney;
    }

    public void increase() {
        this.count++;
    }

    public boolean same(int collectCount) {
        return this.collectCount == collectCount;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getPrizeMoney() {
        return this.money;
    }

    public int getCollectCount() {
        return collectCount;
    }
}
