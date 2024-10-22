package lotto;

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
                new WinningRule(LottoWinnersEnum.THREE, 5000),
                new WinningRule(LottoWinnersEnum.FOUR, 50000),
                new WinningRule(LottoWinnersEnum.FIVE, 1500000),
                new WinningRule(LottoWinnersEnum.SIX, 2000000000)
        ));
    }
}
