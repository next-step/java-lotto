package com.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.lotto.Message.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        int inputPrice = 0;
        try {
            inputPrice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            OutputView.out(PRICE_FORMAT_EXCEPTION.message());
            throw new IllegalArgumentException(PRICE_FORMAT_EXCEPTION.message());
        }
        return inputPrice;
    }

    public static Set<Integer> inputWinningNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        String[] numbers = scanner.nextLine().split(",");
        try {
            for (String number : numbers) {
                winningNumbers.add(Integer.valueOf(number.trim()));
            }
        } catch (Exception exception) {
            OutputView.out(WRONG_INPUT.message());
            throw new IllegalArgumentException(WRONG_INPUT.message());
        }

        return winningNumbers;
    }
}
