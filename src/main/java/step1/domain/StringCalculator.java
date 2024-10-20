package step1.domain;

import java.util.ArrayList;
import java.util.List;

import step1.exception.DivideZeroException;

public final class StringCalculator {

	public static int calculate(String userInput) {
		Expression expression = new Expression(userInput);
		List<String> splittedStringArray = splitUserInput(expression.get());
		List<Integer> numbers = getNumberList(splittedStringArray);
		List<String> operators = getOperatorList(splittedStringArray);
		return calculateWithParams(numbers, operators);
	}

	private static List<String> splitUserInput(String expression) {
		return List.of(expression.split(" "));
	}

	private static List<String> getOperatorList(List<String> splittedStringArray) {
		List<String> operators = new ArrayList<>();
		for (int i = 1; i < splittedStringArray.size(); i += 2) { // 홀수번째 연산자 처리
			operators.add(splittedStringArray.get(i));
		}
		return operators;
	}

	private static List<Integer> getNumberList(List<String> splittedStringArray) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < splittedStringArray.size(); i += 2) { // 짝수번째 숫자 처리
			numbers.add(parseInt(splittedStringArray.get(i)));
		}
		return numbers;
	}

	private static Integer parseInt(String numberString) {
		return Integer.parseInt(numberString);
	}

	private static int calculateWithParams(List<Integer> numbers, List<String> operators) {
		int calculateResult = numbers.get(0);
		numbers.remove(0);
		for (int i = 0; i < operators.size(); i++) {
			calculateResult = calculateWithOperator(calculateResult, operators.get(i), numbers.get(i));
		}
		return calculateResult;
	}

	private static int calculateWithOperator(int result, String operator, Integer number) {
		if (isPlus(operator)) {
			return result + number;
		}
		if (isMinus(operator)) {
			return result - number;
		}
		if (isMultiply(operator)) {
			return result * number;
		}
		if (isDivide(operator)) {
			if (number == 0) {
				throw new DivideZeroException();
			}
			return result / number;
		}
		throw new RuntimeException("알수 없는 에러");
	}

	private static boolean isDivide(String operator) {
		return operator.equals("%") || operator.equals("/");
	}

	private static boolean isMultiply(String operator) {
		return operator.equals("*");
	}

	private static boolean isMinus(String operator) {
		return operator.equals("-");
	}

	private static boolean isPlus(String operator) {
		return operator.equals("+");
	}
}
