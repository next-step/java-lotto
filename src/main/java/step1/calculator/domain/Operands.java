package step1.calculator.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;
import java.util.stream.Collectors;

public class Operands {
	private final Deque<Operand> operands;

	public Operands(Deque<Operand> operands) {
		this.operands = operands;
	}

	public Deque<Operand> getOperands() {
		return operands;
	}

	public static Operands from(String ...strNumbers) throws IllegalArgumentException {
		Deque<Operand> operands = toOperands(strNumbers);

		return new Operands(operands);
	}

	private static Deque<Operand> toOperands(String[] strNumbers) {
		Deque<Operand> operands = Arrays.stream(strNumbers)
			.map(Operand::from)
			.collect(Collectors.toCollection(ArrayDeque::new));

		return operands;
	}

	public void add(Operand operand) {
		operands.add(operand);
	}

	public void addFirst(Operand operand) {
		operands.addFirst(operand);
	}

	public Operand poll() {
		return operands.poll();
	}
}
