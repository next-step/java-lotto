package stringCalculator.domain;

import java.util.HashMap;
import java.util.Map;

public enum OperationEnum {

    ADD("+") {
        @Override
        public Integer apply(Integer result, Integer number) {
            return result + number;
        }
    },

    SUBTRACT("-") {
        @Override
        public Integer apply(Integer result, Integer number) {
            return result - number;
        }
    },

    MULTIPLY("*") {
        @Override
        public Integer apply(Integer result, Integer number) {
            return result * number;
        }
    },

    DIVIDE("/") {
        @Override
        public Integer apply(Integer result, Integer number) {
            return result / number;
        }
    };

    private final String symbol;

    private static final Map<String, OperationEnum> OPERATION_MAP = new HashMap<>();

    static {
        for (OperationEnum operation : OperationEnum.values()) {
            OPERATION_MAP.put(operation.symbol, operation);
        }
    }

    OperationEnum(String symbol) {
        this.symbol = symbol;
    }

    public abstract Integer apply(Integer result, Integer number);

    public static OperationEnum findOperationEnum(String symbol) {
        if (!OPERATION_MAP.containsKey(symbol))
            throw new IllegalArgumentException();

        return OPERATION_MAP.get(symbol);
    }

}
