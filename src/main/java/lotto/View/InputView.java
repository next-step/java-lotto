package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MENT = "구입금액을 입력해 주세요.";
    private static final String FORMAT_ERROR_MENT = "입력형식이 올바르지 않습니다.";
    private static final String PREVIOUS_WINNING_LOTTO_INPUT_MENT = "지난 주 당첨 번호를 입력해 주세요.";

    public static int inputPurchaseAmount(Scanner scanner) {
        try {
            System.out.println(PURCHASE_AMOUNT_INPUT_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(FORMAT_ERROR_MENT);
        }
    }

    public static List<Integer> inputPreviousWinningLotto(Scanner scanner) {
        try {
            System.out.println(PREVIOUS_WINNING_LOTTO_INPUT_MENT);
            scanner.nextLine();
            String temp = scanner.nextLine();
            return convert(temp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new RuntimeException(FORMAT_ERROR_MENT);
        }
    }

    private static List<Integer> convert(String str) {
        return Stream.of(str.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}

