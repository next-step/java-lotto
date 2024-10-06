package calculator.domain.cal;

import calculator.domain.Calculable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CalculableType {

    INIT_OPERATOR("", new InitOperatorCal()),
    SUBTRACTION_OPERATOR("-", new SubtractionCal()),
    MULTIPLICATION_OPERATOR("*", new MultiplicationCal()),
    SUM_OPERATOR("+", new SumCal()),
    DIVISION_OPERATOR("/", new DivisionCal());

    private final static Map<String, CalculableType> operatorTypes;

    static {
        operatorTypes = Arrays.stream(values())
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(CalculableType::getOperator, Function.identity()),
                        Collections::unmodifiableMap));
    }

    private final String operator;
    private final Calculable calculable;

    CalculableType(String operator, Calculable calculable) {
        this.operator = operator;
        this.calculable = calculable;
    }

    public static Calculable getCalculable(String operator) {
        CalculableType factory = Optional.ofNullable(operatorTypes.get(operator))
                .orElseThrow(() ->
                        new IllegalArgumentException("유효하지 않은 연산자 입니다. [" + operator + "]"));

        return factory.calculable;
    }

    public Calculable getCalculable() {
        return calculable;
    }

    public String getOperator() {
        return operator;
    }
}
