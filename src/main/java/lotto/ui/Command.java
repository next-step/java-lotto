package lotto.ui;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.error.ErrorMessage;
import lotto.enums.MessageEnum;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoTicket;
import lotto.shop.Money;

public class Command {
    private static final int ANSWER_SIZE = 6;
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String NUMBER_DELIMITER = ",";

    public static Money inputMoneyAmount() {
        println(MessageEnum.INPUT_MONEY.message());
        String input = SCANNER.nextLine();
        return new Money(toInteger(input));
    }

    public static Set<LottoNumber> inputAnswer() {
        println(MessageEnum.INPUT_LOTTO_ANSWER.message());
        String input = SCANNER.nextLine();
        String[] answer = input.split(NUMBER_DELIMITER);
        checkAnswer(answer);
        return Arrays.stream(answer)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public static void printLottoAmount(int amount) {
        println(MessageEnum.LOTTO_PURCHASE.message(), amount);
    }

    public static void printLottoBundle(LottoTicket lottoTicket) {
        for(Lotto lotto : lottoTicket.tickets()) {
            printLotto(lotto);
        }
    }

    public static void resultMessage() {
        println(MessageEnum.RESULT.message());
        println(MessageEnum.LINE.message());
    }

    private static void printLotto(Lotto lotto) {
        String collect = lotto.numbersToString();
        System.out.println("[" + collect + "]");
    }

    private static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private static void checkAnswer(String[] answer) {
        if (answer.length != ANSWER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER);
        }
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void println(String message, int amount) {
        System.out.println(amount + message);
    }
}