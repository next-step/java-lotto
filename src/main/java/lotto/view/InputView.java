package lotto.view;

import lotto.model.LottoNumber;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_DELIMITER = ", ";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

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

    public List<LottoNumber> inputWinningNumbers() {
        String[] winningNumbers = scanner.nextLine().split(WINNING_NUMBERS_DELIMITER);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(toList());
    }

    public void printBonusNumberInputMessage() {
        printStream.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public Integer inputBonusNumber() {
        return Integer.parseInt(scanner.nextLine());
    }
}
