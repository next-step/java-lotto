package lotto.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String NON_DIGIT_REGEX = "[^0-9]";
    private static final String LOTTO_AMOUNT_PATTERN = "^[1-9]\\d+\\s*원";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요. ");
        String purchaseAmount = input();

        if (!purchaseAmount.trim().matches(LOTTO_AMOUNT_PATTERN)) {
            throw new IllegalArgumentException("올바른 형식의 금액을 입력해주세요!");
        }

        String numericAmount = purchaseAmount.replaceAll(NON_DIGIT_REGEX, "");

        return Integer.parseInt(numericAmount);
    }

    public static Set<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winningLotto = input();

        return toWinningLotto(winningLotto.split(DELIMITER));
    }

    private static Set<Integer> toWinningLotto(String[] values) {

        return Arrays.stream(values)
                .map(InputView::toInt)
                .collect(Collectors.toSet());
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values.trim());

        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }

        return number;
    }



    private static String input() {
        String input = SCANNER.nextLine();

        if (input.isBlank()) {
            throw new IllegalArgumentException("빈값이 입력 되었습니다.");
        }

        return input;
    }
}