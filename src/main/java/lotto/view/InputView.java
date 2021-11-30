package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_SYMBOL = ",";

    private InputView() {
    }

    public static int getNumberInput(String phraseToBeEntered) {
        System.out.println(phraseToBeEntered);
        return validateIntegerInput(scanner.nextLine());
    }

    public static String getInput(String phraseToBeEntered) {
        System.out.println(phraseToBeEntered);
        return scanner.nextLine();
    }

    public static List<Integer> getNumberListFromString(String str) {
        String[] numberArr = str.trim().split(SPLIT_SYMBOL);

        return Arrays.stream(numberArr).map(InputView::validateIntegerInput).collect(Collectors.toList());
    }

    private static int validateIntegerInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException i) {
            throw new IllegalArgumentException("Input should be number");
        }
    }

}
