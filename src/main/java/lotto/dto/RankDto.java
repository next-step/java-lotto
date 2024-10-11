package lotto.dto;

import lotto.entity.PrizeMoney;

public class RankDto {

    private final PrizeMoney prizeMoney;

    private int count = 0;

    public RankDto(PrizeMoney prizeMoney){
        this.prizeMoney = prizeMoney;
    }

    public void increase(){
        this.count++;
    }

    public boolean same(PrizeMoney prizeMoney) {
        return this.prizeMoney == prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public PrizeMoney getPrizeMoney() {
        return prizeMoney;
    }
}
