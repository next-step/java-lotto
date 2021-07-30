package calculator.view;

public class CalculatorOutputView {

	private static final String RESULT_MESSAGE = "실행결과";

	public void calculateResultView(int outputValue) {
		System.out.println(RESULT_MESSAGE);
		System.out.println(outputValue);
	}
}
