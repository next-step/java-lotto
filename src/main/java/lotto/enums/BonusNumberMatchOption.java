package lotto.enums;

import java.util.function.Function;

public enum BonusNumberMatchOption {
    MUST(isBonusNumberMatch -> isBonusNumberMatch),
    NOT(isBonusNumberMatch -> !isBonusNumberMatch),
    OPTIONAL(isBonusNumberMatch -> true);

    private final Function<Boolean, Boolean> bonusNumberMatchFunction;

    BonusNumberMatchOption(Function<Boolean, Boolean> bonusNumberMatchFunction) {
        this.bonusNumberMatchFunction = bonusNumberMatchFunction;
    }

    boolean bonusNumberMatchCheck(boolean bonus) {
        return bonusNumberMatchFunction.apply(bonus);
    }
}
