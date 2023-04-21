package stringcalculator;

import stringcalculator.domain.StringCalculator;
import stringcalculator.ui.InputView;
import stringcalculator.ui.ResultView;

public class StringCalculatorMain {

	public static void main(String[] args) {
		String[] split = InputView.parse(InputView.input());

		String result = split[0];
		for (int i = 1; i < split.length; i += 2) {
			StringCalculator stringCalculator = new StringCalculator(result, split[i + 1], split[i]);
			result = stringCalculator.calculate();
		}

		ResultView.print(result);
	}
}
