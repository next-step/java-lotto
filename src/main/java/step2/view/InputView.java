package step2.view;

import step1.exception.StringAdderExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String LOTTO_START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER= "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA= ",";
    private static final String INPUT_BONUS_NUMBER= "보너스 볼을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchase() {
        System.out.println(LOTTO_START_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        scanner.nextLine();
        return castingToList(splitNumber(scanner.nextLine()));
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }

    private static String[] splitNumber(String input) {
        return input.split(COMMA);
    }

    private static List<Integer> castingToList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .peek(StringAdderExceptionHandler::validate)
                .collect(Collectors.toList());
    }
}
