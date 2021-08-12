package lotto.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final int MIN_MANUAL_LOTTO_COUNT = 0;
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_NUMBERS_DELIMITER = ", ";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTOS_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner;
    private final PrintStream printStream;

    public InputView() {
        scanner = new Scanner(System.in);
        printStream = System.out;
    }

    public void printPurchasePriceInputMessage() {
        printStream.println(PURCHASE_PRICE_INPUT_MESSAGE);
    }

    public int inputPurchasePrice() {
        return scanner.nextInt();
    }

    public void executeNextLine() {
        scanner.nextLine();
    }

    public void printWinningNumbersInputMessage() {
        printStream.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public List<Integer> inputWinningNumbers() {
        String[] winningNumbers = scanner.nextLine().split(INPUT_NUMBERS_DELIMITER);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(toList());
    }

    public void printBonusNumberInputMessage() {
        printStream.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public Integer inputBonusNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void printManualLottoCountInputMessage() {
        printStream.println(MANUAL_LOTTO_COUNT_INPUT_MESSAGE);
    }

    public Integer inputManualLottoCount() {
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        validateMinManualLottoCount(manualLottoCount);
        return manualLottoCount;
    }

    private void validateMinManualLottoCount(int manualLottoCount) {
        if (manualLottoCount < MIN_MANUAL_LOTTO_COUNT) {
            throw new IllegalArgumentException(String.format("수동 로또 개수는 최소 %d개 이상이어야 합니다.",
                    MIN_MANUAL_LOTTO_COUNT));
        }
    }

    public void printManualLottosInputMessage() {
        printStream.println(MANUAL_LOTTOS_INPUT_MESSAGE);
    }

    public List<Integer> inputManualLotto() {
        String[] manualLottoNumbers = scanner.nextLine().split(INPUT_NUMBERS_DELIMITER);
        return Arrays.stream(manualLottoNumbers)
                .map(Integer::parseInt)
                .collect(toList());
    }

    public void printNewLine() {
        printStream.println();
    }
}
