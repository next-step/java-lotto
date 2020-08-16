package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MULTI_DATA_DELIMITER = ",";
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ILLEGAL_NUMBER_FORMAT_EXCEPTION_MESSAGE = "입력 형식이 올바르지 않습니다.";

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return parseToInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        return parseToIntegers(scanner.nextLine(), INPUT_MULTI_DATA_DELIMITER);
    }

    public static int parseToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static List<Integer> parseToIntegers(String inputValue, String delimiterRegex) {
        try {
            return Arrays.stream(inputValue.split(delimiterRegex))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
