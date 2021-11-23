package lotto.step2.view;

import lotto.step2.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {
        throw new AssertionError();
    }

    public static int printInputOrderPrice() {
        System.out.println("구매 금액을 입력해주세요");
        String orderPrice = sc.nextLine();
        checkOrderPrice(orderPrice);
        return Integer.parseInt(orderPrice);
    }

    public static List<Integer> printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        System.out.println();
        return setWinningNumbers(input);
    }

    private static List<Integer> setWinningNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(s -> Integer.valueOf(s.trim()))
                .collect(Collectors.toList());
    }

    private static void checkOrderPrice(String orderPrice) {
        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
        }
    }

}
