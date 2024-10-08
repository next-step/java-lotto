package view;

import java.util.Scanner;

public class InputView {
    private static Scanner SC = new Scanner(System.in);

    public static String getInput() {
        System.out.println("입력 해주세요");
        return SC.nextLine();
    }

    public static Integer getPaidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SC.nextLine());
    }

    public static String[] splitByEmptyString(String input) {
        if (input == null || input.replaceAll(" ", "").isEmpty()) {
            throw new IllegalArgumentException("input must not empty string");
        }
        if (!input.replaceAll(" ", "").replaceAll("[0-9]", "").matches("[+\\-*/\\s]+")) {
            throw new IllegalArgumentException("input must contain arithmetic characters");
        }
        return input.split(" ");
    }
}
