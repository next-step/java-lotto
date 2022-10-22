package calculator;

public class OutputView {

	private static final String RESULT_PREFIX = "계산 결과: ";

	public void printResult(int result) {
		System.out.println(RESULT_PREFIX + result);
	}
}
