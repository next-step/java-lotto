package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String requestOperation() {
        System.out.println("수식을 입력하세요.");
        return validate(scanner.nextLine());
    }

    public static int requestPurchaseAmount() {
        System.out.println("구매할 금액을 입려하세요.");
        return validateInt(scanner.nextInt());
    }

    public static List<Integer> requestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] input = scanner.next().split(",");
        return Arrays.stream(input)
            .map(String::trim)
            .map(Integer::parseInt)
            .map(InputView::validateInt)
            .collect(Collectors.toList());
    }

    public static String validate (String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값을 입력해주세요.");
        }
        return input;
    }

    public static int validateInt (int input) {
        if (input<0) {
            throw new IllegalArgumentException("음수일 수 없습니다.");
        }
        return input;
    }
}
