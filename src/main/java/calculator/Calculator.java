package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

	public static final String DELIMITER = " ";

	Queue<Number> numbers = new LinkedList<>();

	Queue<Operator> operators = new LinkedList<>();

	public int calculate(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("null 또는 공백은 입력할 수 없습니다.");
		}

		String[] s = input.split(DELIMITER);
		// 완성된 계산식은 숫자 + 연산자의 갯수가 홀수여야한다.
		if (s.length % 2 != 1) {
			throw new IllegalArgumentException("잘못된 계산식 입니다.");
		}

		numbers.add(new Number(s[0]));
		for (int i = 1; i < s.length; i++) {
			operators.add(Operator.of(s[i]));
			numbers.add(new Number(s[++i]));
		}

		int result = numbers.poll().getValue();
		while (!operators.isEmpty()) {
			int num = numbers.poll().getValue();
			Operator operator = operators.poll();
			result = operator.operate(result, num);
		}

		return result;
	}

}
