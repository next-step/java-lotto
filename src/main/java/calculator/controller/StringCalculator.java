package calculator.controller;

import calculator.domain.Expression;
import calculator.domain.Number;
import calculator.domain.Operator;

public class StringCalculator {
	static final char PLUS = '+';
	static final char MINUS = '-';
	static final char MULTIPLY = '*';
	static final char DIVIDE = '/';
	public Number calculate(Expression expression){
		Addition addition = new Addition();
		for (int i = 0; i < expression.operators().size(); i++) {
			if (expression.operators().get(i).equals(new Operator(PLUS))){
				expression.numbers().set(i+1, addition.plus(expression.numbers().get(i), expression.numbers().get(i+1)));
			}
		}
		return expression.numbers().get(expression.operators().size());
	}

}
