package lotto.view;

import lotto.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ", ";

    private Input() {
    }

    private static String input(){
        return SCANNER.nextLine();
    }

    public static int inputPrice(){
        String input = input();
        return Integer.parseInt(input);
    }

    public static List<Number> inputWinnerNumbers(){
        String input = input();
        String[] split = input.split(SEPARATOR);

        List<Number> numbers = new ArrayList<>();
        for (String number : split) {
            numbers.add(Number.of(number));
        }
        return numbers;
    }

}
