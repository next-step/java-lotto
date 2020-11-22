package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            result = scanner.next();
        } while(stringValidationCheck(result));
        return result;
    }

    public static int inputBonusLottoNumber() {
        int result;
        do {
            System.out.print(INPUT_BONUS_BALL_NUMBER_MESSAGE);
        } while((result = bonusNumberCheck(scanner.nextInt())) == 0);
        scanner.nextLine();
        return result;
    }

    public static List<Lotto> inputManualLottoNumber() {
        int lottoCount = inputManualLottoCount();
        System.out.print(INPUT_LOTTO_MANUAL_NUMBER_MESSAGE);
        return IntStream.range(0,lottoCount)
                .mapToObj(e -> manualLottoNumber())
                .map(InputView::manualLotto)
                .collect(Collectors.toList());
    }

    private static Lotto manualLotto(String lottoNumber) {
        String[] splitLottoNumber = lottoNumber.split(LOTTO_NUMBER_SEPARATOR);
        List<LottoNumber> lottoNumbers = Arrays.stream(splitLottoNumber)
                .map(e -> LottoNumber.of(Integer.parseInt(e)))
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers,false);
    }

    private static String manualLottoNumber() {
        String result;
        do {
            result = scanner.next();
        } while(stringValidationCheck(result));
        return result;
    }

    private static int inputManualLottoCount() {
        int result;
        do {
            System.out.print(INPUT_LOTTO_MANUAL_COUNT_MESSAGE);
            result = scanner.nextInt();
        } while(integerValidationCheck(result));
        return result;
    }

    private static boolean integerValidationCheck(int result) {
        if(result < 0) {
            System.out.print(LOTTO_COUNT_CHECK_ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private static int priceCheck(int price) {
        if(price < LOTTO_PRICE || price % 1000 != 0) {
            System.out.print(PRICE_CHECK_ERROR_MESSAGE);
            return 0;
        }
        return price;
    }

    private static int bonusNumberCheck(int number) {
        if(number > 0 && number <= MAX_LOTTO_NUMBER) {
            return number;
        }
        System.out.print(BONUS_NUMBER_CHECK_ERROR_MESSAGE);
        return 0;
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
