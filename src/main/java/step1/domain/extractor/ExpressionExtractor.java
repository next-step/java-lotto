package step1.domain.extractor;

import step1.domain.num.Num;
import step1.domain.operator.Operator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpressionExtractor {

    private List<Num> numList;
    private List<Operator> operatorList;

    public ExpressionExtractor(String[] strings) {
        validateExtract(strings);
        addNumIterator(strings);
        addOperatorIterator(strings);
    }

    private void addNumIterator(String[] strings) {
        this.numList = IntStream.range(0, strings.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> new Num(strings[i]))
                .collect(Collectors.toList());
    }

    private void addOperatorIterator(String[] strings) {
        this.operatorList = IntStream.range(0, strings.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> new Operator(strings[i]))
                .collect(Collectors.toList());
    }

    private void validateExtract(String[] strings) {
        IntStream.range(0, strings.length)
                .filter(i -> i % 2 == 0)
                .forEach(i -> validateNumber(strings[i]));

        IntStream.range(0, strings.length)
                .filter(i -> i % 2 == 1)
                .forEach(i -> validateOperator(strings[i]));
    }

    private void validateNumber(String num) {
        if (isStringNum(num)) return;
        throwExpressionIllegalArgumentException();
    }

    private void validateOperator(String operator) {
        if (isOperator(operator)) return;
        throwExpressionIllegalArgumentException();
    }

    private void throwExpressionIllegalArgumentException() {
        throw new IllegalArgumentException("수식이 올바르지 않습니다.");
    }

    private boolean isStringNum(String input) {
        return input.matches("\\d+");
    }

    private boolean isOperator(String input) {
        return input.matches("[+\\-*/%]");
    }
}
