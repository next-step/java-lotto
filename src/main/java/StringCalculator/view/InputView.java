package StringCalculator.view;

import java.util.Scanner;

public class InputView {

    private static final InputView inputView = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private static final String SCANNER_READ_LINE_BREAK= "\\n";
    private static final String STRING_LINE_BREAK= "\n";

    private InputView() {
    }

    public String readUserInput() {
        String userInputString = askUserInput();

        scanner.close();

        return userInputString;
    }

    private String askUserInput() {
        System.out.println("연산을 행할 문자열을 입력해주세요. (예1: \"1,2,3\") (예2: \"//;\\n1;2;3\"): ");
        return scanner.next().replace(SCANNER_READ_LINE_BREAK, STRING_LINE_BREAK);
    }


    public static InputView getInstance() {
        return inputView;
    }
}
