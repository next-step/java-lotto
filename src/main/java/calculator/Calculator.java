package calculator;

import calculator.tokenizer.ExpressionTokenizer;
import java.util.List;

public class Calculator {

    private final ExpressionTokenizer tokenizer;

    public Calculator(ExpressionTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public int calc(String value) {
        return calc(tokenize(value));
    }

    private List<String> tokenize(String value) {
        List<String> tokenize = tokenizer.tokenize(value);
        if (isUnValid(tokenize)) {
            throw new IllegalArgumentException("잘못된 문법 입니다.");
        }
        return tokenize;
    }

    private boolean isUnValid(List<String> tokenize) {
        return tokenize.size() < 3;
    }

    private int calc(List<String> tokenize) {
        int result=Integer.parseInt(tokenize.get(0));
        for (int i = 1; i < tokenize.size() - 1; i+=2) {
            Operation operation = Operation.from(tokenize.get(i));
            result=operation.apply(result, toInt(tokenize, i));
        }
        return result;
    }

    private int toInt(List<String> tokenize, int i) {
        return Integer.parseInt(tokenize.get(i + 1));
    }
}
