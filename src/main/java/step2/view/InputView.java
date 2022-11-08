package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR_COMMA = ",";
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요. (한장에 1000원)";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String EXCEPTION_MESSAGE = "숫자와 콤마만 입력해 주세요";

    private InputView() {}

    public static String purchasePriceInput() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return SCANNER.nextLine();
    }

    public static List<Integer> winningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return createWinningNumbers(SCANNER.nextLine());
    }

    public static List<Integer> createWinningNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR_COMMA))
                .map(InputView::parseInteger)
                .collect(Collectors.toList());
    }

    private static int parseInteger(String index) {
        try {
            return Integer.parseInt(index);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(EXCEPTION_MESSAGE);
        }
    }

}