package step1.view;

import java.util.Scanner;

import static step1.constants.QuestionConstants.PUT_FORMULA;

public class OperatorInputView {

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PUT_FORMULA);
        return scanner.nextLine();
    }
}
