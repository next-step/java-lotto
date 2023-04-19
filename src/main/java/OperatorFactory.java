import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

    private final Map<String, Operator> operatorFactory;

    private OperatorFactory(Map<String, Operator> operatorFactory) {
        this.operatorFactory = operatorFactory;
    }

    public static OperatorFactory createFactory() {
        Map<String, Operator> factory = new HashMap<>();

        factory.put("+", new PlusOperator());
        factory.put("-", new MinusOperator());
        factory.put("/", new DevideOperator());
        factory.put("*", new MultipleOperator());

        return new OperatorFactory(factory);
    }

    public Operator selectOperator(String operator) {
        if (!operatorFactory.containsKey(operator))
            throw new IllegalArgumentException("유효한 사칙연산 기호를 입력해주세요.");

        return operatorFactory.get(operator);
    }
}
