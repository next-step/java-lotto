package pluscalculator.argument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operands {

	private static final Operands ZERO = new Operands(Arrays.asList(0));

	private final List<Integer> operands;
	private int currentIndex;

	private Operands(List<Integer> operands) {
		this.operands = operands;
		this.currentIndex = 0;
	}

	public static final Operands zero() {
		return ZERO;
	}

	private static Operands of(List<Integer> operands) {
		return new Operands(operands);
	}

	public static Operands from(String[] operandsArray) {
		return Operands.of(Stream.of(operandsArray)
								 .map(operand -> Integer.parseInt(operand))
								 .collect(Collectors.toList()));
	}

	public String[] toStringArray() {
		String[] operandsArray = new String[operands.size()];
		for (int i = 0; i < operands.size(); i++) {
			operandsArray[i] = String.valueOf(operands.get(i));
		}
		return operandsArray;
	}

	public boolean hasNext() {
		return operands.size() > currentIndex + 1;
	}

	public int next() {
		return operands.get(++currentIndex);
	}

	public int getFirst() {
		return operands.get(0);
	}


}
