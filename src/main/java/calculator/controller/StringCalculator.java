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
		Division division = new Division();
		Multiplication multiplication = new Multiplication();
		Subtraction subtraction = new Subtraction();
		for (int i = 0; i < expression.operators().size(); i++) {
			if (expression.operators().get(i).equals(new Operator(PLUS))){
				expression.numbers().set(i+1, addition.plus(expression.numbers().get(i), expression.numbers().get(i+1)));
			}
			if (expression.operators().get(i).equals(new Operator(MINUS))){
				expression.numbers().set(i+1, subtraction.minus(expression.numbers().get(i), expression.numbers().get(i+1)));
			}
			if (expression.operators().get(i).equals(new Operator(MULTIPLY))){
				expression.numbers().set(i+1, multiplication.multiply(expression.numbers().get(i), expression.numbers().get(i+1)));
			}
			if (expression.operators().get(i).equals(new Operator(DIVIDE))){
				expression.numbers().set(i+1, division.divide(expression.numbers().get(i), expression.numbers().get(i+1)));
			}
		}
		return expression.numbers().get(expression.operators().size());
	}

}
