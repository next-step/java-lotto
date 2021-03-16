package step1.service;

import step1.domain.Operator;
import step1.domain.Tokens;

public class Calculator {
    private Operator operator;
    private Tokens tokens;

    public Calculator(String inputText) {
        this.tokens = new Tokens(inputText);
        this.operator = new Operator();
    }

    public int sum() {
        return operator.totalSum(tokens);
    }
}
