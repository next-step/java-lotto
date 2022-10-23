package calculator.domain;

import java.util.Arrays;

import calculator.exception.ErrorMessage;
import calculator.exception.OperatorInvalidException;
import calculator.exception.ZeroDivideException;

public enum Operator {
	ADDITION("+") {
		@Override
		public int operate(int preOperand, int postOperand) {
			return preOperand + postOperand;
		}
	},
	SUBTRACTION("-") {
		@Override
		public int operate(int preOperand, int postOperand) {
			return preOperand - postOperand;
		}
	},
	MULTIPLICATION("*") {
		@Override
		public int operate(int preOperand, int postOperand) {
			return preOperand * postOperand;
		}
	},
	DIVISION("/") {
		@Override
		public int operate(int preOperand, int postOperand) {
			try {
				return preOperand / postOperand;
			} catch (ZeroDivideException exception) {
				throw new ZeroDivideException(ErrorMessage.ZERO_DIVIDE);
			}
		}
	};

	private final String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public static Operator findBySymbol(String value) {
		return Arrays.stream(values())
			.filter(operator -> operator.getSymbol().equals(value))
			.findAny()
			.orElseThrow(() -> new OperatorInvalidException(ErrorMessage.INVALID_OPERATOR, value));
	}

	public String getSymbol() {
		return symbol;
	}

	public abstract int operate(int preOperand, int postOperand);
}
