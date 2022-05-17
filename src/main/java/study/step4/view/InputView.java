package study.step4.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static final InputView instance = new InputView();

    private InputView() {}

    public static InputView getInstance() {
        return instance;
    }

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputManualLottoQuantity() {
        System.out.println(INPUT_MANUAL_QUANTITY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputWinnerNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<List<Integer>> inputManualLottoNumbers(int manualLottoQuantity) {
        if (manualLottoQuantity > 0) {
            System.out.println(INPUT_MANUAL_NUMBERS_MESSAGE);
        }
        return Stream.generate(this::inputNumbers)
                .limit(manualLottoQuantity)
                .collect(Collectors.toList());
    }

    private List<Integer> inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        return stringToIntegers(scanner.nextLine());
    }

    private List<Integer> stringToIntegers(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(e -> Integer.parseInt(e.trim()))
                .collect(Collectors.toList());
    }
}
