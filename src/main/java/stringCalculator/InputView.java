package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String regExp = "^[0-9]+$";
    private final String[] operations = {"+", "-", "*", "/"};

    private final String splitRegex = " ";

    public String[] init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("식을 입력하세요");
        String input = scanner.nextLine();
        return splitInput(input);
    }

    public String[] splitInput(String input) {
        emptyValidate(input);
        String[] result = input.split(splitRegex);
        for (String s : result) {
            operatorValidate(s);
        }
        return result;
    }

    public void emptyValidate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public void operatorValidate(String s) {
        List<String> operationList = Arrays.asList(operations);
        if (!operationList.contains(s) && !s.matches(regExp)) {
            throw new IllegalArgumentException();
        }
    }
}
