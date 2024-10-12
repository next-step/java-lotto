package calculator.domain;

import calculator.domain.operator.Operator;
import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Operators {

    private final List<Operator> operators;

    public Operators(String... symbols) {
        if (StringUtil.isEmpty(symbols)) {
            throw new IllegalArgumentException("연산자를 입력해 주세요.");
        }

        this.operators = Arrays.stream(symbols)
                .map(Operator::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Iterator<Operator> iterator() {
        return operators.iterator();
    }
}
