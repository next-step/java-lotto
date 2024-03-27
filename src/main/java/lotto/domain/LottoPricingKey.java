package lotto.domain;

public enum LottoPricingKey {

    COMMON_KEY((a, b) -> String.valueOf(a)),
    BONUS_KEY((a, b) -> a+":"+b),;
    final LottoPricingKeyFunction function;
    LottoPricingKey(LottoPricingKeyFunction function) {
        this.function = function;
    }

    public static LottoPricingKey getKey(int matchCount){
        if(isBonusMatchCount(matchCount)) return BONUS_KEY;
        return COMMON_KEY;
    }

    public static boolean isBonusMatchCount(int matchCount){
        return matchCount == 5;
    }

    public String get(int count, boolean condition){
        return this.function.get(count, condition);
    }
}
