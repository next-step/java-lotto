package calculator.view;

import java.io.PrintStream;

public class OutputView {

    private static final String RESULT_MESSAGE = "계산 결과 : ";
    private static final PrintStream PRINT_STREAM = System.out;

    public static void printResult(int result) {
        PRINT_STREAM.print(RESULT_MESSAGE);
        PRINT_STREAM.println(result);
    }
}
