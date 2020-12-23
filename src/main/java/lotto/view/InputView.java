package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final String EMPTY_REGEX = "\\s+";

    public int inputAmount(Scanner scanner) {
        return scanner.nextInt();
    }

    public Integer[] inputLuckyNumbers(Scanner scanner) {
        String[] numbers = scanner.nextLine().replaceAll(EMPTY_REGEX, "").split(SPLIT_REGEX);
        Integer[] luckyNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            luckyNumbers[i] = Integer.parseInt(numbers[i]);
        }
        return luckyNumbers;
    }

}
