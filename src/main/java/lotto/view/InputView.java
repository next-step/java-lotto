package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNINGNUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNINGNUMBER_DELIMITER = ", ";

    public int inputPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return toInt(SCANNER.nextLine());
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(System.lineSeparator() + INPUT_WINNINGNUMBERS_MESSAGE);
        return split(SCANNER.nextLine());
    }

    private List<Integer> split(String input) {
        return Arrays.stream(input.split(WINNINGNUMBER_DELIMITER))
                .map(this::toInt)
                .collect(toList());
    }

}
