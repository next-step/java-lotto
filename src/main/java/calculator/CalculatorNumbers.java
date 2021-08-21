package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorNumbers {
	private final List<CalculatorNumber> calculatorNumbers;

	public CalculatorNumbers(List<String> splintedNumbers) {
		this.calculatorNumbers = splintedNumbers
			.stream()
			.map(number -> new CalculatorNumber(number))
			.collect(Collectors.toList());
	}

	public CalculatorNumber sumAll() {
		CalculatorNumber result = new CalculatorNumber(0);

		for (int i = 0; i < calculatorNumbers.size(); i++) {
			CalculatorNumber sum = result.add(calculatorNumbers.get(i));
			result = sum;
		}

		return result;
	}
}
