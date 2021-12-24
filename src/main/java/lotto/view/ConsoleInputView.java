package lotto.view;

import lotto.exception.LottoGameException;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements Closeable {

    private static final String MONEY_INPUT_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "구매금액은 숫자만 입력하세요.";

    private static final String WINNING_NUMBERS_INPUT_PROMPT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_DELIMITER = ", ";

    private final Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    private void printPaymentInputPromptMessage() {
        System.out.println(MONEY_INPUT_PROMPT_MESSAGE);
    }

    private void printWinningNumbersInputPromptMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_PROMPT_MESSAGE);
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public int inputMoneyToPay() {
        printPaymentInputPromptMessage();

        String paymentString = nextLine();

        int money;
        try {
            money = Integer.parseInt(paymentString);
        } catch (NumberFormatException e) {
            throw new LottoGameException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }

        return money;
    }

    public List<Integer> inputWinningLottoNumbers() {
        printWinningNumbersInputPromptMessage();

        String[] winningNumbersStrings = nextLine().split(WINNING_NUMBERS_INPUT_DELIMITER);

        return Arrays.stream(winningNumbersStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }

}
