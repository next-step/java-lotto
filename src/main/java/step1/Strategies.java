package step1;

import step1.CalculateStratety.*;

import java.util.HashMap;
import java.util.Map;

public class Strategies {

    private static Map<String, CalculateStrategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put("+", new Plus());
        strategyMap.put("-", new Minus());
        strategyMap.put("*", new Multi());
        strategyMap.put("/", new Divide());
    }

    public CalculateStrategy getStrategy(String sign) {
        return strategyMap.get(sign);
    }
}
