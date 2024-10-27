package lotto.domain;

import java.util.List;

public class WinningRules {

    private final List<WinningRule> rules;

    public WinningRules(List<WinningRule> rules) {
        this.rules = rules;
    }


    public List<WinningRule> getAllRules() {
        return this.rules;
    }

    public static WinningRules getDefaultWinningRules() {
        return new WinningRules(List.of(
                WinningRule.THREE,
                WinningRule.FOUR,
                WinningRule.FIVE,
                WinningRule.SIX
        ));
    }
}
