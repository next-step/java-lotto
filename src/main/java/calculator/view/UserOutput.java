package calculator.view;

public class UserOutput {

	public static final String NEXT_LINE_FLAG = "\n";
	private static final String PRINT_USER_INPUT_EXPRESSION = "계산식을 입력해 주세요. (구분자는 `,` 와 `:`이며, 새로운 구분자는 //을 추가한뒤 입력 후 엔터)";
	private static final String PRINT_USER_OUTPUT_RESULT = "계산식 결과 :";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printUserErrorMsg(String msg) {

		messagePrint(msg + NEXT_LINE_FLAG);
	}

	public static void printUserInputExpression() {

		messagePrint(PRINT_USER_INPUT_EXPRESSION + NEXT_LINE_FLAG);
	}

	public static void printCalculateResult(int sumValue) {

		messagePrint(PRINT_USER_OUTPUT_RESULT + sumValue + NEXT_LINE_FLAG);
	}
}
