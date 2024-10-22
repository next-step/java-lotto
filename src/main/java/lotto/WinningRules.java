package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningRules {

    private final Map<Integer, WinningRule> rules;

    public WinningRules(List<WinningRule> rules) {
        this.rules = new HashMap<>();
        for (WinningRule rule : rules) {
            this.rules.put(rule.getMatch(), rule);
        }
    }

    public List<WinningRule> getAllRules() {
        return this.rules.keySet()
                .stream()
                .sorted()
                .map(rules::get)
                .collect(Collectors.toList());
    }

    public Integer getReward(Integer match) {
        return this.rules.get(match).getReward();
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
