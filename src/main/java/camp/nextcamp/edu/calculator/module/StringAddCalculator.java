package camp.nextcamp.edu.calculator.module;

import static camp.nextcamp.edu.util.StringUtils.*;

import java.util.List;

import camp.nextcamp.edu.calculator.entity.CalculatorNumberInput;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return 0;
		}

		PatternStringTokenizer tokenizer = PatternTokenizerFactory.getTokenizer(input);
		List<String> inputs = tokenizer.makeListByPatternSplit(input);

		return sum(inputs);
	}

	private static int sum(List<String> inputs) {
		return inputs.stream()
			.map(CalculatorNumberInput::new)
			.map(CalculatorNumberInput::getInputTypeInt)
			.reduce(0, (acc, cur) -> acc + cur);
	}
}
