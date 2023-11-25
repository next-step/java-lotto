package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBERS_DELIMITER = ", ";
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println(QUESTION_WINNING_NUMBERS);
        return convertStringToInt(scanner.nextLine());
    }

    private static List<Integer> convertStringToInt(String numbers) {
        return Arrays.stream(numbers.split(NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusBallNumber() {
        System.out.println();
        System.out.println(QUESTION_BONUS_BALL);
        return Integer.parseInt(scanner.nextLine());
    }
}
