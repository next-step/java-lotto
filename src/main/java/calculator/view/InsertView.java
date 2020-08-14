package calculator.view;

import calculator.context.Message;
import calculator.util.MessageUtil;

import java.util.Scanner;

public class InsertView {
    private final static Scanner scanner = new Scanner(System.in);

    private InsertView() {
        throw new AssertionError();
    }

    public static String inputText() {
        MessageUtil.msgPrint(Message.INPUT_MSG);
        return scanner.nextLine();
    }

}
