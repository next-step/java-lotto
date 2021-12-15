package lotto.view;

import lotto.domain.Money;
import lotto.exception.LottoApplicationException;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class MoneyInputView implements Closeable {

    private static final String MONEY_INPUT_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "구매금액은 숫자만 입력하세요.";

    private final Scanner scanner;

    public MoneyInputView() {
        scanner = new Scanner(System.in);
    }

    private void printPaymentInputPromptMessage() {
        System.out.println(MONEY_INPUT_PROMPT_MESSAGE);
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

    @Override
    public void close() throws IOException {
        scanner.close();
    }

}
