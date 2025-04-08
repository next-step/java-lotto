package lotto.view;

import common.InputValidator;
import common.message.ErrorMessage;
import common.message.InputMessage;
import common.message.OutputMessage;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static common.message.OutputMessage.WINNING_NUMBERS;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPERATOR = ",";

    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT);

        while (true) {
            try {
                String input = SCANNER.nextLine();
                int amount = Integer.parseInt(input);

                InputValidator.validatePurchaseAmount(amount);
                return amount;

            } catch (NumberFormatException e) {
                System.out.println(OutputMessage.ERROR_PREFIX + ErrorMessage.INVALID_PURCHASE_AMOUNT);

            } catch (IllegalArgumentException e) {
                System.out.println(OutputMessage.ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS);

        while (true) {
            try {
                String input = SCANNER.nextLine();
                List<Integer> numbers = parseNumbers(input);

                return Lotto.copyOf(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(OutputMessage.ERROR_PREFIX + e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(SEPERATOR);
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
