package step1;

import java.util.List;

public class StringCalculator {

    private final List<Token> tokens;

    public StringCalculator(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {

        Status status = new Status(0, 0);

        while(status.index < tokens.size()) {
            Token token = tokens.get(status.index);
            processToken(token, status);
        }

        return status.result;
    }

    private void processToken(Token token, Status status) {
        if(token.isNumber() && status.index == 0 ) {
            status.result = token.toInt();
            status.index++;
            return;
        }
        if(token.isPlusOperator()) {
            status.result = plus(status.result, tokens.get(status.index + 1).toInt());
            status.index+=2;
            return;
        }
        if(token.isMinusOperator()) {
            status.result = minus(status.result, tokens.get(status.index + 1).toInt());
            status.index+=2;
            return;
        }
        if(token.isMultiplyOperator()) {
            status.result = multiply(status.result, tokens.get(status.index + 1).toInt());
            status.index+=2;
            return;
        }
        if(token.isDevideOperator()) {
            status.result = divide(status.result, tokens.get(status.index + 1).toInt());
            status.index+=2;
            return;
        }
    }

    private int plus(int a, int b) {
    	return a + b;
    }

    private int minus(int a, int b) {
    	return a - b;
    }

    private int multiply(int a, int b) {
    	return a * b;
    }

    private int divide(int a, int b) {
    	return a / b;
    }

    static class Status {
    	private int index;
    	private int result;

    	public Status(int index, int result) {
    		this.index = index;
    		this.result = result;
    	}

    }
}
