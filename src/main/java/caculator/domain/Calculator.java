package caculator.domain;

import java.util.List;

public class Calculator {
    public static int calculate(List<String> values) {
        int total = Integer.parseInt(values.get(0));
        for (int i = 1; i < values.size(); i += 2) {
            String sign = values.get(i);
            int num = Integer.parseInt(values.get(i+1));
            total = Operator.of(sign).calculate(total, num);
        }
        return total;
    }
}
