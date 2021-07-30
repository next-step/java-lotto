package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.view.exception.InvalidParseIntegerException;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTotalAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();

        return parseInteger(input);
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new InvalidParseIntegerException();
        }
    }

    public static Set<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return parseIntegers(input, ",");
    }

    private static Set<Integer> parseIntegers(String input, String delimiter) {
        try {
            return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toSet());
        } catch (NumberFormatException ex) {
            throw new InvalidParseIntegerException();
        }
    }

    public static int inputWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();

        return parseInteger(input);
    }
}
