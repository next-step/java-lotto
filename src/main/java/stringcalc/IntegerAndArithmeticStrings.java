package stringcalc;

import java.util.HashMap;
import java.util.Map;

public class IntegerAndArithmeticStrings {
    private static final Map<String, String> operatorMap = new HashMap<>();
    static {
        operatorMap.put("+", "PLUS");
        operatorMap.put("-", "MINUS");
        operatorMap.put("*", "MULTIPLY");
        operatorMap.put("/", "DIVISION");
    }

    private final String[] strings;

    public IntegerAndArithmeticStrings(String[] strings) {
        if (strings.length % 2 == 0 || strings.length < 1) {
            throw new IllegalArgumentException("유효하지 않은 문자열");
        }

        this.strings = strings;
    }

    public int calculate() {
        int integer;
        int processNumber = Integer.parseInt(strings[0]);
        for (int i = 1; i < strings.length; ++i) {
            ArithmeticOperation operator = ArithmeticOperation.valueOf(operatorMap.getOrDefault(strings[i], ""));
            processNumber = operator.execute(processNumber, Integer.parseInt(strings[++i]));
        }

        return processNumber;
    }

}
