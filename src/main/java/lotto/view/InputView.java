package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.view.exception.InvalidInputTotalAmountException;
import lotto.view.exception.InvalidParseIntegerException;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static long inputTotalAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        long totalAmount = parseLong(input);
        validationInputTotalAmount(totalAmount);

        return Long.parseLong(input);
    }

    private static void validationInputTotalAmount(long totalAmount) {
        if (totalAmount < 0) {
            throw new InvalidInputTotalAmountException();
        }
    }

    private static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException ex) {
            throw new InvalidParseIntegerException();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return parseIntegers(input, ",");
    }

    private static List<Integer> parseIntegers(String input, String delimiter) {
        try {
            return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new InvalidParseIntegerException();
        }
    }
}
