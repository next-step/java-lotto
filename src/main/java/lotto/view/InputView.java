package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA = ", ";
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BEFORE_LOTTO_NUMBER = String.format("%s지난 주 당첨 번호를 입력해 주세요.", System.lineSeparator());
    private static final Function<Integer, String> BUY_LOTTO_MESSAGE = price -> (price / 1000) + "개를 구매했습니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String stringInput() {
        return SCANNER.nextLine();
    }

    public static int intInput() {
        return Integer.parseInt(stringInput());
    }

    public static int buyingLotto() {
        ResultView.print(BUY_MESSAGE);
        int price = intInput();

        String buyingMessage = BUY_LOTTO_MESSAGE.apply(price);
        ResultView.print(buyingMessage);

        return price;
    }

    public static Lotto typingBeforeLotto() {
        ResultView.print(BEFORE_LOTTO_NUMBER);

        String input = stringInput();
        List<Number> beforeLotto = Arrays
                .stream(input.split(COMMA))
                .sorted()
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());

        return Lotto.draw(beforeLotto);
    }
}
