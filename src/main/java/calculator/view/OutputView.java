package calculator.view;

public class OutputView {
	private static final String OUTPUT_MESSAGE = "계산 결과는 %d 입니다.";

	public void printOutput(int output) {
		System.out.printf(OUTPUT_MESSAGE + "%n", output);
	}
}
