package lotto.view;

import common.InputValidator;
import common.message.ErrorMessage;
import common.message.InputMessage;
import common.message.OutputMessage;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

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
}
