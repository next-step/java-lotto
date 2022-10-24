package calculator.view;

import java.util.Scanner;

public class InputView {

    public static final String QUESTION_START = "연산식을 입력하세요";

    Scanner scanner = new Scanner(System.in);

    public String scanString() {
        printQuestionStart();
        return StringResult();
    }

    private String StringResult() {
        return scanner.nextLine();
    }

    private void printQuestionStart() {
        System.out.println(QUESTION_START);
    }

}
