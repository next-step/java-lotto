package lotto.view;

import lotto.common.Delimiter;
import lotto.model.Lotto;
import lotto.model.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String stringInput() {
        return SCANNER.nextLine();
    }

    public static int intInput() {
        return Integer.parseInt(stringInput());
    }

    public static Lotto inputBeforeLotto() {
        String input = stringInput();
        List<Number> beforeLotto = Arrays
                .stream(input.split(Delimiter.COMMA.symbol))
                .sorted()
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());

        return new Lotto().draw(beforeLotto);
    }
}
