package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorContext {
	public static final String CUSTOM_DELIMITER_FINDER = "//(.)\n(.*)";
	public static final String DEFAULT_DELIMITER = ",|:";
	private final CalculatorDelimiter delimiter;
	private final CalculatorExpression expression;

	public CalculatorContext(String calculatorInput) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_FINDER).matcher(calculatorInput);
		if (m.find()) {
			this.delimiter = new CalculatorDelimiter(m.group(1));
			this.expression = new CalculatorExpression(m.group(2));
			return;
		}
		this.delimiter = new CalculatorDelimiter(DEFAULT_DELIMITER);
		this.expression = new CalculatorExpression(calculatorInput);
	}

	public CalculatorExpression expression() {
		return this.expression;
	}

	public CalculatorDelimiter delimiter() {
		return this.delimiter;
	}
}
