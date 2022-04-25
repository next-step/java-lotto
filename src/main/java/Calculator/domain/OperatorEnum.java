package Calculator.domain;

import Calculator.domain.Calculation.Calculation;
import Calculator.domain.Calculation.DivisionCalculation;
import Calculator.domain.Calculation.MinusCalculation;
import Calculator.domain.Calculation.PlusCalculation;
import Calculator.domain.Calculation.TimesCalculation;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum OperatorEnum {
    PLUS("+", new PlusCalculation()),
    MINUS("-", new MinusCalculation()),
    TIMES("*", new TimesCalculation()),
    DIVISION("/", new DivisionCalculation());

    private static final Map<String, OperatorEnum> ENUM_MAP;

    private final String sign;
    private final Calculation calculation;

    static {
        ENUM_MAP = Arrays.stream(OperatorEnum.values())
                .collect(Collectors.toUnmodifiableMap(OperatorEnum::getSign, operatorEnum -> operatorEnum));
    }

    OperatorEnum(String sign, Calculation calculation) {
        this.sign = sign;
        this.calculation = calculation;
    }

    public static OperatorEnum get(String sign) {
        validateSign(sign);
        return ENUM_MAP.get(sign);
    }

    private static void validateSign(String sign) {
        if (sign == null) {
            throw new IllegalArgumentException("연산기호는 null일 수 없습니다.");
        }

        if (!ENUM_MAP.containsKey(sign)) {
            throw new IllegalArgumentException(String.format("연산기호(%s)가 올바르지 않습니다.", sign));
        }
    }

    public Calculation getCalculation() {
        return calculation;
    }

    private String getSign() {
        return sign;
    }
}
