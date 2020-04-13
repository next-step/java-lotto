package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Prize {
    MISS(0, 0, (match, bonusNumber) -> match < 3),
    FIFTH(3, 5000, (match, bonusNumber) -> match == 3),
    FOURTH(4, 50_000, (match, bonusNumber) -> match == 4),
    THIRD(5, 150_0000, (match, bonusNumber) ->  match == 5 && !bonusNumber),
    SECOND(5, 30_000_000, (match, bonusNumber) ->  match == 5 && bonusNumber),
    FIRST(6, 2000_000_000, (match, bonusNumber) -> match == 6);

    private int match;
    private int amount;
    private BiFunction<Integer, Boolean, Boolean> matcher;

    Prize(int match, int amount, BiFunction<Integer, Boolean, Boolean> matcher) {
        this.match = match;
        this.amount = amount;
        this.matcher = matcher;
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }

    static Prize of(int match, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(v -> v.match(match, bonusNumber))
                .findFirst()
                .orElse(Prize.MISS);
    }

    public Boolean match(int matchCount, boolean bonusNumber) {
        return matcher.apply(matchCount, bonusNumber);
    }

}
