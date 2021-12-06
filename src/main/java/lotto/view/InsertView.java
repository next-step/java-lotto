package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String READ_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String READ_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String COMMA = ",";

    private InsertView() {
        throw new AssertionError();
    }

    public static String printInputIntro() {
        System.out.println(READ_MONEY_MESSAGE);

        return scanner.nextLine();
    }

    public static String printManualInput() {

        System.out.println(READ_MANUAL_COUNT_MESSAGE);

        return scanner.nextLine();
    }

    public static List<String> printInputLottoNumbers(int manualInputCount) {

        System.out.println(READ_MANUAL_NUMBERS_MESSAGE);
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualInputCount; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public static List<Integer> printInputWinningNumbers() {
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return setWinningNumbers(input);
    }

    private static List<Integer> setWinningNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(s -> Integer.valueOf(s.trim()))
                .collect(Collectors.toList());
    }

    public static String printInputBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String bonusBall = scanner.nextLine();

        return bonusBall;
    }

}
