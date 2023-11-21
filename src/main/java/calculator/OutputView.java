package calculator;

public class OutputView {
	public static void printResult(Calculator calculator) {
		System.out.printf("계산 결과값은 %d 입니다.", calculator.result());
	}
}
