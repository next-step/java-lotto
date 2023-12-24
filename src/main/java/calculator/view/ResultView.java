package calculator.view;

import calculator.domain.Digit;

public final class ResultView {
	public static void printResult(Digit result) {
		System.out.println("결과 : " + result.digit());
	}
}
