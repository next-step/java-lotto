package step1.view;

public class OutputView {

        private static final String RESULT_MESSAGE = "결과는 %d 입니다.";

        public static void printResult(int result) {
            System.out.println(String.format(RESULT_MESSAGE, result));
        }
}
