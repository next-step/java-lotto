package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.common.ErrorMessage;
import lotto.common.PrintMessage;
import lotto.lotto.Lotto;
import lotto.shop.Money;

public class Command {
    private static final int ANSWER_SIZE = 6;
    private static final String NUMBER_DELIMITER = ",";
    private final Scanner scanner;

    public Command() {
        scanner = new Scanner(System.in);
    }

    public Money inputMoneyAmount() {
        PrintMessage.INPUT_MONEY.print();
        String input = scanner.nextLine();
        return new Money(toInteger(input));
    }

    public Set<Integer> inputAnswer() {
        PrintMessage.INPUT_LOTTO_ANSWER.print();
        String input = scanner.nextLine();
        String[] answer = input.split(NUMBER_DELIMITER);
        checkAnswer(answer);
        return Arrays.stream(answer)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    public void printLottoAmount(int amount) {
        PrintMessage.LOTTO_PURCHASE.print(amount);
    }

    public void printLottoBundle(List<Lotto> lottoBundle) {
        for(Lotto lotto : lottoBundle) {
            printLotto(lotto);
        }
    }

    public void resultMessage() {
        PrintMessage.RESULT.print();
        PrintMessage.LINE.print();
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
}
