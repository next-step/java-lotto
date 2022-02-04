package calculator.view;

public class OutputView {

    private static final String REQUEST_FORMULA_INPUT = "수식을 입력해주세요: ";
    private static final String REQUIRE_FORMULA = "(쉼표(,) 세미콜론(;)은 기본 구분자이며, 커스텀 구분자도 입력할 수 있습니다.)";
    public static final String ERROR = "[ERROR] ";
    public static final String ERROR_NEGATIVE_NUMBER = "입력한 문자열에 음수가 있습니다.";

    public static void printRequestFormulaInput() {
        System.out.println(REQUEST_FORMULA_INPUT + REQUIRE_FORMULA);
    }
}
