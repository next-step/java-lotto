package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner SC = new Scanner(System.in);

    public static String getInput() {
        System.out.println("입력 해주세요");
        return SC.nextLine();
    }

    public static Integer getPaidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(SC.nextLine());
        if (money <= 0) {
            throw new IllegalArgumentException("input money must be greater than 0");
        }
        return money;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = SC.nextLine();
        List<Integer> result = Arrays.stream(line.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (result.size() > 6) {
            throw new IllegalArgumentException("input length must be less than or equal to 6");
        }
        return result;
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
