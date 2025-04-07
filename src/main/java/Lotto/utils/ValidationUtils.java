package Lotto.utils;

import Lotto.view.InputView;

public class ValidationUtils {
    public static boolean isInvalidNumber(String input, int min, int max) {
        int number = InputView.trimAndReturnInt(input);

        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        if ( number < min || number > max) {
            return true;
        }

        return false;
    }
}
