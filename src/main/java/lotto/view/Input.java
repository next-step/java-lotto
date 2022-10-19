package lotto.view;

import lotto.Number;

import java.util.*;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ", ";

    private Input() {
    }

    private static String input() {
        return SCANNER.nextLine();
    }

    public static int inputPrice() {
        String input = input();
        return Integer.parseInt(input);
    }

    public static Set<Number> inputWinnerNumbers() {
        String input = input();
        String[] split = input.split(SEPARATOR);

        Set<Number> numbers = new TreeSet<>();
        for (String number : split) {
            numbers.add(Number.of(number));
        }
        return numbers;
    }

    public static Number inputBonusNumber() {
        String input = input();
        return Number.of(input);
    }

}
