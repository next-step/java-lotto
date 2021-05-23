package lotto.ui;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.common.ErrorMessage;
import lotto.common.PrintMessage;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoTicket;
import lotto.shop.Money;

public class Command {
    private static final int ANSWER_SIZE = 6;
    private static final String NUMBER_DELIMITER = ",";
    private final Scanner scanner;

    public Command() {
        scanner = new Scanner(System.in);
    }

    public Money inputMoneyAmount() {
        println(MessageEnum.INPUT_MONEY.message());
        String input = scanner.nextLine();
        return new Money(toInteger(input));
    }

    public Set<LottoNumber> inputAnswer() {
        println(MessageEnum.INPUT_LOTTO_ANSWER.message());
        String input = scanner.nextLine();
        String[] answer = input.split(NUMBER_DELIMITER);
        checkAnswer(answer);
        return Arrays.stream(answer)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public void printLottoAmount(int amount) {
        println(MessageEnum.LOTTO_PURCHASE.message(), amount);
    }

    public void printLottoBundle(LottoTicket lottoTicket) {
        for(Lotto lotto : lottoTicket.tickets()) {
            printLotto(lotto);
        }
    }

    public void resultMessage() {
        println(MessageEnum.RESULT.message());
        println(MessageEnum.LINE.message());
    }

    private void printLotto(Lotto lotto) {
        String collect = lotto.numbers().stream().sorted()
                .map(Object::toString)
                .collect(Collectors.joining(NUMBER_DELIMITER));
        System.out.println("[" + collect + "]");
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private void checkAnswer(String[] answer) {
        if (answer.length != ANSWER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER);
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println(String message, int amount) {
        System.out.println(amount + message);
    }
}
