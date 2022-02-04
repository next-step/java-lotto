package lotto.view;

import java.util.Scanner;

public class InputView {

    public static String inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return input();
    }

    private static String input() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        validateBlank(input);

        return input;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return input();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return input();
    }

    private static void validateBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }
}
