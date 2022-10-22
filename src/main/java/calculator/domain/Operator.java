package calculator.domain;

import java.util.Arrays;

import calculator.exception.ErrorMessage;
import calculator.exception.OperatorInvalidException;
import calculator.exception.ZeroDivideException;

public enum Operator {
	ADDITION("+") {
		@Override
		public int operate(Operand preOperand, Operand postOperand) {
			return preOperand.getNumber() + postOperand.getNumber();
		}
	},
	SUBTRACTION("-") {
		@Override
		public int operate(Operand preOperand, Operand postOperand) {
			return preOperand.getNumber() - postOperand.getNumber();
		}
	},
	MULTIPLICATION("*") {
		@Override
		public int operate(Operand preOperand, Operand postOperand) {
			return preOperand.getNumber() * postOperand.getNumber();
		}
	},
	DIVISION("/") {
		@Override
		public int operate(Operand preOperand, Operand postOperand) {
			try {
				return preOperand.getNumber() / postOperand.getNumber();
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

	public abstract int operate(Operand preOperand, Operand postOperand);
}
