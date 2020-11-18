package lotto.view;

import java.util.Arrays;
import java.util.Scanner;

import static lotto.domain.LottoRuleConfig.*;
import static lotto.view.InputViewConfig.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputPrice() {
        int result;
        do {
            System.out.print(INPUT_PRICE_MESSAGE);
        } while((result = priceCheck(scanner.nextInt())) == 0);
        scanner.nextLine();
        return result;
    }

    public static String inputLottoNumber() {
        String result;
        do {
            System.out.print(INPUT_LOTTO_NUMBER_MESSAGE);
            result = scanner.nextLine();
        } while(stringValidationCheck(result));
        return result;
    }

    private static int priceCheck(int price) {
        if(price < LOTTO_PRICE) {
            System.out.print(PRICE_CHECK_ERROR_MESSAGE);
            return 0;
        }
        return price;
    }

    private static boolean stringValidationCheck(String number) {
        if(number == null || number.equals("")) {
            System.out.print(INPUT_EMPTY_ERROR_MESSAGE);
            return true;
        }
        return numberFormatCheck(number);
    }

    private static boolean numberFormatCheck(String number) {
        int parseInt = numberFormatRegexMatches(number);
        return lottoNumberSizeCheck(parseInt);
    }

    private static int numberFormatRegexMatches(String number) {
        return (int) Arrays.stream(number.split(LOTTO_NUMBER_SEPARATOR))
                .filter(n -> n.trim().matches(NUMBER_REGEX)).count();
    }

    private static boolean lottoNumberSizeCheck(int number) {
        if(number != MAX_LOTTO_BALL_COUNT) {
            System.out.print(INPUT_ARRAY_SIZE_ERROR_MESSAGE);
            return true;
        }
        return false;
    }
}
