package step1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum OperatorEnum {

    ADD("+", new Addition()),
    SUB("-", new Subtraction()),
    MUL("*", new Multiplication()),
    DIV("/", new Division());

    private String symbol;
    private Operator operator;

    private static final Map<String, Operator> OPERATOR_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(OperatorEnum::getSymbol, OperatorEnum::getOperator)));

    private static final List<String> OPERATOR_SYMBOL_LIST = new ArrayList<>(OPERATOR_MAP.keySet());

    public static Operator getOperator(String symbol) {
        return OPERATOR_MAP.get(symbol);
    }

    public static boolean isValidSymbol(String symbol) {
        return OPERATOR_SYMBOL_LIST.contains(symbol);
    }
}
