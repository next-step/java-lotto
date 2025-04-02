package ui;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "Please input string:";

    public String[] readAndSplitInput() {
        String input = getInput();
        return splitString(input);
    }

    public static String getInput() {
        System.out.println(INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    public void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 문자열 입니다.");
        }
    }

    public String[] splitString(String input) {
        return input.trim()
                .split("\\s+");
    }

}

