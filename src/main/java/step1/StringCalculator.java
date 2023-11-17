package step1;

import java.util.List;

public class StringCalculator {

    private final List<Token> tokens;
    private int index = 0;
    private int result = 0;

    public StringCalculator(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {

        while(index < tokens.size()) {
            Token token = tokens.get(index);
            processToken(token);
        }

        return result;
    }

    private void processToken(Token token) {
        if(token.isNumber() && index == 0 ) {
            result = token.toInt();
            index++;
            return;
        }
        if(token.isPlusOperator()) {
            result = plus(result, tokens.get(index + 1).toInt());
            index+=2;
            return;
        }
        if(token.isMinusOperator()) {
            result = minus(result, tokens.get(index + 1).toInt());
            index+=2;
            return;
        }
        if(token.isMultiplyOperator()) {
            result = multiply(result, tokens.get(index + 1).toInt());
            index+=2;
            return;
        }
        if(token.isDevideOperator()) {
            result = divide(result, tokens.get(index + 1).toInt());
            index+=2;
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
}
