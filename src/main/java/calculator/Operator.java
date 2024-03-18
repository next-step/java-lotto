package calculator;

import java.util.HashMap;

public enum Operator {
	SUM("+"){
		@Override
		public int operate(int input1, int input2) {
			return input1 + input2;
		}
	},
	SUBTRACT("-"){
		@Override
		public int operate(int input1, int input2) {
			return input1 - input2;
		}
	},
	MUTIPLY("*"){
		@Override
		public int operate(int input1, int input2) {
			return input1 * input2;
		}
	},
	DIVIDE("/"){
		@Override
		public int operate(int input1, int input2) {
			return input1 / input2;
		}
	};

	private static final HashMap<String, Operator> operatorMap = new HashMap<>();

	private final String mark;

	static {
		operatorMap.put(SUM.mark, SUM);
		operatorMap.put(SUBTRACT.mark, SUBTRACT);
		operatorMap.put(MUTIPLY.mark, MUTIPLY);
		operatorMap.put(DIVIDE.mark, DIVIDE);
	}

	Operator(String mark) {
		this.mark = mark;
	}

	public static Operator of(String mark) {
		Operator found = operatorMap.get(mark);
		if (found == null) {
			throw new IllegalArgumentException("잘못된 연산자를 입력하셨습니다.");
		}

		return found;
	}

	public abstract int operate(int input1, int input2);

}
