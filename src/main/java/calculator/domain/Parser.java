package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	public String[] splitString(String input) {
		return input.trim()
			.split("\\s+");
	}

	public List<Operand> parseOperand(String[] tokens) {
		List<Operand> operands = new ArrayList<>();
		for (int i = 0; i < tokens.length; i += 2) {
			operands.add(new Operand(Integer.parseInt(tokens[i])));
		}
		return operands;
	}

	public List<Operator> parseOperator(String[] tokens) {
		List<Operator> operators = new ArrayList<>();
		for (int i = 1; i < tokens.length; i += 2) {
			operators.add(Operator.fromSymbol(tokens[i]));
		}
		return operators;
	}

}
