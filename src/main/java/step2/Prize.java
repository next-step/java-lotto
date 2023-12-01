package step2;

import java.util.Arrays;

public enum Prize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    UNKNOWN(0,0);


    private final int value;
    private final int money;

    Prize(int value, int money) {
        this.value = value;
        this.money = money;
    }

    public int calculatePrize(Prize prize, int matchCount){
        return prize.money * matchCount;
    }

    public String printValue(){
        return this.value + "개 일치 (" + this.money + "원)= ";
    }

    static Prize of(int value) {
        return Arrays.stream(values())
                .filter(v -> value == (v.value))
                .findFirst()
                .orElse(Prize.UNKNOWN);
    }

}
