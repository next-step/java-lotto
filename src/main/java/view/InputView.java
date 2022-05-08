package view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;
    private static final String DELIMITER = " ";
    private static final String INPUT_MESSAGE = "문자열을 입력해 주세요";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getInput(){
        System.out.println(INPUT_MESSAGE);
        String input = scanner.nextLine();
        return input.split(DELIMITER);
    }

}
