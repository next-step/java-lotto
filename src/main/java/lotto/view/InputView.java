package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMEITER = ",";
    private static final String INPUT_SEED_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MANUAL_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
    }


    public static int inputSeedMoney() {
        System.out.println(INPUT_SEED_MESSAGE);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String token) {
        return Integer.parseInt(token.trim());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_MESSAGE);

        return toIntTokens(splitToken(scanner.nextLine()));
    }

    public static int inputBounusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return toInt(scanner.nextLine());
    }

    public static int inputManualCount() {
        System.out.println(INPUT_MANUAL_MESSAGE);
        return toInt(scanner.nextLine());
    }

    public static List<List<Integer>> inputLottosNumbers(int manualLottoCount) {
        System.out.println(INPUT_MANUAL_NUMBER_MESSAGE);
        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> toIntTokens(splitToken(scanner.nextLine())))
                .collect(Collectors.toList());
    }

    private static List<String> splitToken(String input) {
        return List.of(input.split(SPLIT_DELIMEITER));
    }

    private static List<Integer> toIntTokens(List<String> tokens) {
        return tokens.stream()
                .map(token -> toInt(token))
                .collect(Collectors.toList());
    }
}
