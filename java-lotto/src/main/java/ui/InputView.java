package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "Please input string:";

    public String[] readAndSplitInput(String input) {
        return splitString(input);
    }

    public String getInput() {
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

    public int getPurchaseAmount() {
        System.out.println("Please enter the purchase amount.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("Please enter last week's winning number.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

}

