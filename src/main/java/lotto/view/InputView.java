package lotto.view;

import java.util.Scanner;

import lotto.domain.Money;
import lotto.domain.User;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입 금액을 입력해주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public User getUserInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return new User(new Money(scanner.nextInt()));
    }
}
