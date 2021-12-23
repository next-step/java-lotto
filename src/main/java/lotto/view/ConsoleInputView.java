package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.exception.LottoApplicationException;

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

    public Money inputMoneyToPay() {
        printPaymentInputPromptMessage();

        String paymentString = nextLine();

        int money;
        try {
            money = Integer.parseInt(paymentString);
        } catch (NumberFormatException e) {
            throw new LottoApplicationException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }

        return new Money(money);
    }

    public LottoNumbers inputWinningNumbers() {
        printWinningNumbersInputPromptMessage();

        String[] winningNumbersStrings = nextLine().split(WINNING_NUMBERS_INPUT_DELIMITER);

        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumbersStrings)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }

}
