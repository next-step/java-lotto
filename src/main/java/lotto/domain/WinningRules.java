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
                new WinningRule(LottoWinners.THREE, 5000),
                new WinningRule(LottoWinners.FOUR, 50000),
                new WinningRule(LottoWinners.FIVE, 1500000),
                new WinningRule(LottoWinners.SIX, 2000000000)
        ));
    }
}
