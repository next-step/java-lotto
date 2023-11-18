package calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {
	public int run(String input) {
		String[] inputs = input.split(" ");
		List<String> inputList = List.of(inputs);
		Stack<Integer> numberStack = new Stack<>();
		Stack<String> signStack = new Stack<>();

		for (int i = inputList.size()-1; i >= 0; i--) {
			if (i % 2 == 0) {
				numberStack.add(parseInt(inputList.get(i)));
			}
			if (i % 2 != 0) {
				signStack.add(inputList.get(i));
			}
		}

		while (!signStack.isEmpty()) {
			int firstNo = numberStack.pop();
			int secondNo = numberStack.pop();
			String sign = signStack.pop();

			if (sign.equals("+")) {
				numberStack.push(firstNo + secondNo);
			}
			if (sign.equals("-")) {
				numberStack.push(firstNo - secondNo);
			}
			if (sign.equals("*")) {
				numberStack.push(firstNo * secondNo);
			}
			if (sign.equals("/")) {
				numberStack.push(firstNo / secondNo);
			}
		}
		return numberStack.pop();
	}

	private static int parseInt(String input) {
		return Integer.parseInt(input);
	}
}
