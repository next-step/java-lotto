package stringCalculator.view;

import stringCalculator.utils.Message;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String inputData() {
        System.out.println(Message.QUESTION_FOR_CALCULATOR.getMessage());
        return checkInputData(scanner.nextLine());
    }

    private String checkInputData(String inputData) {
        if (inputData.isBlank() || inputData == null) {
            throw new IllegalArgumentException(Message.INPUT_DATA_NULL_OR_BLACK.getMessage());
        }
        return inputData;
    }
}
