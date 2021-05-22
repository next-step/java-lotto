package com.lotto.ui;

import com.lotto.domain.Lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.lotto.ui.Message.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() throws IllegalArgumentException {
        int inputPrice = 0;
        try {
            inputPrice = Integer.parseInt(scanner.nextLine());
            if(inputPrice < Lotto.UNIT_PRICE) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            OutputView.out(PRICE_FORMAT_EXCEPTION.message());
            throw new IllegalArgumentException(PRICE_FORMAT_EXCEPTION.message());
        } catch (IllegalArgumentException exception) {
            OutputView.out(UNDER_UNIT_PRICE.message());
            throw new IllegalArgumentException(UNDER_UNIT_PRICE.message());
        }
        return inputPrice;
    }

    public static Set<Integer> inputWinningNumbers() throws IllegalArgumentException {
        Set<Integer> winningNumbers = new HashSet<>();
        String[] numbers = scanner.nextLine().split(",");
        try {
            for (String number : numbers) {
                winningNumbers.add(Integer.valueOf(number.trim()));
            }
            if (winningNumbers.size() != Lotto.LOTTO_COUNT) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException exception) {
            OutputView.out(WRONG_INPUT.message());
            throw new IllegalArgumentException(WRONG_INPUT.message());
        } catch (IllegalArgumentException exception) {
            OutputView.out(WRONG_LOTTO_NUMBER_COUNT.message());
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_COUNT.message());
        }

        return winningNumbers;
    }
}
