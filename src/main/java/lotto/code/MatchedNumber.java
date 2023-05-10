package lotto.code;

import java.util.EnumSet;

public enum MatchedNumber {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
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

    public static MatchedNumber findByNumberWithMatchedBonus(int number, boolean isMatchedBonus) {
        if (number == 5 && isMatchedBonus) return FIVE_AND_BONUS;
        return EnumSet.allOf(MatchedNumber.class)
                .stream()
                .filter(matchedNumber -> number == matchedNumber.getNumber())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 일치 번호 입니다."));
    }

    public static boolean isMatchedNumberFiveAndBonus(MatchedNumber matchedNumber) {
        return FIVE_AND_BONUS == matchedNumber;
    }

}
