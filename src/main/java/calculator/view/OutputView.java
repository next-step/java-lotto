package calculator.view;

public class OutputView {
    private static StringBuilder stringBuilder = new StringBuilder();

    private static String PRINT_RESULT_MESSAGE = "계산 결과 값 : ";

    public static void printResult(int resultNumber) {
        clearStringBuilder();

        stringBuilder.append(PRINT_RESULT_MESSAGE)
                .append(resultNumber);

        System.out.println(stringBuilder);
    }

    private static void clearStringBuilder() {
        stringBuilder.setLength(0);
    }
}
