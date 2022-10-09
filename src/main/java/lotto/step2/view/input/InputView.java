package lotto.step2.view.input;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.PaymentPrice;
import lotto.step2.domain.WinningLottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    private static final String LOTTO_PAYMENT_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요. (1000원 단위)";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요. (구분자는 콤마, 각 숫자 범위는 1 ~ 45)";
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String LOTTO_PAYMENT_PRICE_INPUT_FORM = "[1-9][0-9]*000";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_FORM = "(4[0-5]|[1-3][0-9]|[1-9])(,(4[0-5]|[1-3][0-9]|[1-9])){5}";
    private static final String LOTTO_BONUS_NUMBER_INPUT_FORMAT = "^4[0-5]|[1-3][0-9]|[1-9]$";
    private static final String LOTTO_BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    
    public static PaymentPrice lottoPaymentPriceInput() {
        try {
            System.out.println(LOTTO_PAYMENT_PRICE_INPUT_MESSAGE);
            return lottoPaymentPriceInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoPaymentPriceInput();
        }
    }
    
    public static PaymentPrice lottoPaymentPriceInput(String input) {
        checkNullException(input);
        checkLottoPaymentPriceInputFormatException(input);
        return new PaymentPrice(Integer.parseInt(input));
    }
    
    private static void checkLottoPaymentPriceInputFormatException(String input) {
        Matcher matcher = Pattern.compile(LOTTO_PAYMENT_PRICE_INPUT_FORM).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void checkNullException(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    public static WinningLottoNumbers winningLottoNumber() {
        try {
            return new WinningLottoNumbers(winningLottoNumbersInput(), winningBonusLottoNumberInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningLottoNumber();
        }
    }
    
    public static List<LottoNumber> winningLottoNumbersInput() {
        System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
        return winningLottoNumbersInput(SCANNER.nextLine());
    }
    
    public static List<LottoNumber> winningLottoNumbersInput(String input) {
        checkNullException(input);
        checkWinningLottoNumbersInputFormatException(removeSpace(input));
        return getLottoNumbers(removeSpace(input));
    }
    
    private static void checkWinningLottoNumbersInputFormatException(String input) {
        Matcher matcher = Pattern.compile(WINNING_LOTTO_NUMBERS_INPUT_FORM).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    private static String removeSpace(String input) {
        return input.replace(SPACE, EMPTY);
    }
    
    private static List<LottoNumber> getLottoNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }
    
    public static LottoNumber winningBonusLottoNumberInput() {
        System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
        return winningBonusLottoNumberInput(SCANNER.nextLine());
    }
    
    public static LottoNumber winningBonusLottoNumberInput(String input) {
        checkNullException(input);
        checkWinningLottoBonusNumberInputFormatException(input);
        return new LottoNumber(Integer.parseInt(input));
    }
    
    private static void checkWinningLottoBonusNumberInputFormatException(String input) {
        Matcher matcher = Pattern.compile(LOTTO_BONUS_NUMBER_INPUT_FORMAT).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
