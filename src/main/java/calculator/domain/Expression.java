package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	private final List<Number> numbers;
	private final List<Operator> operators;

	public Expression(String input) {
		numbers = new ArrayList<>();
		operators = new ArrayList<>();
		String[] strings = input.split(" ");
		for (String string:strings) {
			parseExpression(string);
		}
	}

	public List<Number> numbers(){
		return numbers;
	}
	public List<Operator> operators(){
		return operators;
	}
	private void parseExpression(String string){
		char character = string.charAt(0);
		if (character == '+' || character == '-' || character == '*' || character == '%'){
			operators.add(new Operator(character));
		}
		if (Character.isDigit(character)){
			numbers.add(new Number(character-'0'));
		}
	}
}
