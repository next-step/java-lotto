package lotto.domain;

import java.util.function.Function;

public enum BonusMatching {
    TRUE(matching -> matching),
    FALSE(matching -> !matching),
    IRRELEVANT(matching -> matching || !matching);

    private final Function<Boolean, Boolean> matcher;

    BonusMatching(Function<Boolean, Boolean> matcher) {
        this.matcher = matcher;
    }

    public boolean match(boolean bonus) {
        return matcher.apply(bonus);
    }
}
