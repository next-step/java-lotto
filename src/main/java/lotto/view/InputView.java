package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBERS_MESSAGE = "방송에서 뽑힌 당첨 번호 6개를 입력해 주세요. 쉼표(,)로 구분합니다.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String DEFAULT_SPLIT_REGEX = ",";

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputManualQuantity() {
        System.out.println(INPUT_MANUAL_QUANTITY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Integer> inputWinnerNumber() {
        return inputNumbers(INPUT_WINNER_NUMBERS_MESSAGE);
    }

    private List<Integer> inputNumbers(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return stringToIntegers(scanner.nextLine());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> stringToIntegers(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
