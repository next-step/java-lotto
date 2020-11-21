package view;

public final class ResultView {

    public static final String RESULT_PREFIX = " => ";

    public static void displayResult(int result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_PREFIX).append(result);
        System.out.println(stringBuilder);
    }
}
