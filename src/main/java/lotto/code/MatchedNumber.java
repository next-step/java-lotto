package lotto.code;

import java.util.EnumSet;

public enum MatchedNumber {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int number;
    private final int amount;

    MatchedNumber(int number, int amount) {
        this.number = number;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public static MatchedNumber findByNumber(int number) {
        return EnumSet.allOf(MatchedNumber.class)
                .stream()
                .filter(matchedNumber -> number == matchedNumber.getNumber())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 일치 횟수 입니다."));
    }

}
