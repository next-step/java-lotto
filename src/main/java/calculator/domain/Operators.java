package calculator.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class Operators {

    private final List<IntBinaryOperator> operators;

    Operators(String... symbols) {
        if (symbols == null || symbols.length == 0) {
            throw new IllegalArgumentException("연산자를 입력해 주세요.");
        }

        this.operators = Arrays.stream(symbols)
                .map(Operation::findOperatorBySymbol)
                .collect(Collectors.toUnmodifiableList());
    }

    Iterator<IntBinaryOperator> iterator() {
        return operators.iterator();
    }
}
