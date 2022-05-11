package lotto.view;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Number;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ", ";
    private static final String PAYMENT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String BEFORE_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Game createGame() {
        ResultView.print(PAYMENT_MESSAGE);
        int price = intValue();

        return Game.pay(price);
    }

    public static Lotto getBeforeLotto() {
        ResultView.print();
        ResultView.print(BEFORE_LOTTO_MESSAGE);

        String plain = stringValue();
        List<Integer> values = Stream
                .of(plain.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Lotto.manual(values);
    }

    public static Number getBonusNumber() {
        ResultView.print(BONUS_NUMBER_MESSAGE);
        return Number.of(intValue());
    }

    public static int intValue() {
        return Integer.parseInt(stringValue());
    }

    public static String stringValue() {
        return SCANNER.nextLine();
    }
}
