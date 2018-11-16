package lotto.validator;

import java.util.Scanner;

import static lotto.utils.LottoNumberGenerator.LOTTO_NUMBER_LENGTH;

public class LottoValidator {

    private LottoValidator() {

    }

    public static void throwExceptionWhenHasNoInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }
    }

    public static void throwExceptionWhenHasNoText(String[] texts) {
        if(texts.length < LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < texts.length; i++) {
            try {
                Integer.parseInt(texts[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
