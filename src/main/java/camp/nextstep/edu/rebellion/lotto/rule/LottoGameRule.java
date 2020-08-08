package camp.nextstep.edu.rebellion.lotto.rule;

import java.util.*;

public class LottoGameRule {
    private static final Map<String, Integer> rules = new HashMap<>();

    static {
        Properties prop = LottoGameRulePropertiesLoader.load();
        prop.stringPropertyNames()
                .forEach(key -> rules.put(key, Integer.parseInt(prop.getProperty(key))));
    }

    private LottoGameRule() {}

    public static int getLottoCount() {
        return getRules("lotto.count");
    }

    public static int getLottoPrice() {
        return getRules("lotto.price");
    }

    public static int getLottoNumberMin() {
        return getRules("lotto.number.min");
    }

    public static int getLottoNumberMax() {
        return getRules("lotto.number.max");
    }

    private static int getRules(String key) {
        return Optional.ofNullable(rules.get(key))
                .orElseThrow(() -> new IllegalArgumentException("없는 규칙 입니다" + key));
    }
}
