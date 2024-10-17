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
}
