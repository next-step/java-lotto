package lotto.step3.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String COMMA = ",";
    private static final int LOTTO_SIZE = 6;

    private InputView() {
        throw new AssertionError();
    }

    public static int printInputOrderPrice() {
        System.out.println("구매 금액을 입력해주세요");
        String orderPrice = sc.nextLine();
        checkIsDigit(orderPrice);
        return Integer.parseInt(orderPrice);
    }

    public static List<Integer> printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] input = sc.nextLine().split(COMMA);
        Arrays.stream(input)
                .forEach(InputView::checkIsDigit);
        List<Integer> winningNumbers = Arrays.stream(input)
                .map(s -> Integer.valueOf(s.trim()))
                .collect(Collectors.toList());
        checkNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int PrintInputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요");
        String bonusBall = sc.nextLine();
        checkIsDigit(bonusBall);
        System.out.println();
        return Integer.parseInt(bonusBall);
    }

    private static void checkIsDigit(String orderPrice) {
        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
        }
    }

    private static void checkNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 입력 해주세요!!");
        }
        numbers.forEach(n -> {
            if (!(1 <= n && n <= 45)) {
                throw new IllegalArgumentException("1~45 숫자를 입력해주세요!!");
            }});
    }

}
