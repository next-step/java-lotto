package calculator;

import calculator.model.Calculator;
import calculator.view.UserView;

public class CalculatorMain {

	public static final int ILLEGAL_EXCEPTION_SUM_VALUE = 0;

	public static void main(String[] args) {

		try {

			// 계산기 객체 생성 // 유저 계산식 입력
			Calculator calculator = new Calculator(UserView.getUserInputExpression());

			// 계산 후 결과 프린트
			UserView.printCalculateResult(calculator.getSum());
		} catch (IllegalArgumentException illegalArgumentException) {

			// 에러 메세지 프린트
			UserView.printErrorMsg(illegalArgumentException.getMessage());

			// 결과 0 출력
			UserView.printCalculateResult(ILLEGAL_EXCEPTION_SUM_VALUE);
		} catch (RuntimeException runtimeException) {

			// 에러 메세지 프린트
			UserView.printErrorMsg(runtimeException.getMessage());
		}
	}
}
