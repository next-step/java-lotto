package stringcalculator.view;

public class OutputView {
    private final static String RESULT_COMMAND = "실행 결과 : ";

    public static void printOutput(int result) {
        System.out.print(RESULT_COMMAND);
        System.out.println(result);
    }
}
