package caculator;

import java.util.List;
import java.util.Map;

public class Calculator {
    private static final Map<String, Expression> expressionMap = ExpressionType.expressionMap();

    public int calculate(List<String> values) {
        int tot = Integer.parseInt(values.get(0));
        for (int i = 1; i < values.size(); i += 2) {
            String sign = values.get(i);
            int num = Integer.parseInt(values.get(i+1));
            tot = expressionMap.get(sign).calculate(tot, num);
        }
        return tot;
    }
}
