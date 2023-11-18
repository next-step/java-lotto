package calculator;

import java.util.Stack;

public class Signs {
	private final Stack<Sign> signs;

	public Signs(Stack<Sign> signs) {
		this.signs = signs;
	}

	public void push(Sign sign) {
		signs.push(sign);
	}

	public Sign pop() {
		return signs.pop();
	}
}
