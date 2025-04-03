package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int read(String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        try {
            validate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return read(question);
        }
    }

    private static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다. 다시 입력해주세요.");
        }
        if (!isInteger(input.trim())) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
        }
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("0 또는 음수가 입력되었습니다. 다시 입력해주세요.");
        }
    }

    private static boolean isInteger(String input) {
        return input != null && input.matches("\\d+");
    }

    public static String readWinningNumbers(String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        try {
            validateWinningNumbers(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers(question);
        }
    }

    private static void validateWinningNumbers(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다. 다시 입력해주세요.");
        }
        if (!input.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException("쉼표(,)로 구분된 6개의 숫자를 입력해주세요.");
        }
    }

    public static int readBonusNumber(String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        try {
            validateBonusNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(question);
        }
    }

    private static void validateBonusNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다. 다시 입력해주세요.");
        }
        if (!isInteger(input.trim())) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");
        }
    }


}
