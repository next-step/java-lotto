package lotto.step2.view.input;

import lotto.step2.domain.LottoNumber;
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
    private static final String LOTTO_PAYMENT_PRICE_INPUT_FORM = "[1-9][0-9]*000";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_FORM = "(4[0-5]|[1-3][0-9]|[1-9])(,(4[0-5]|[1-3][0-9]|[1-9])){5}";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요. (구분자는 콤마, 각 숫자 범위는 1 ~ 45)";
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    
    public static int lottoPaymentPriceInput() {
        try {
            System.out.println(LOTTO_PAYMENT_PRICE_INPUT_MESSAGE);
            return lottoPaymentPriceInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoPaymentPriceInput();
        }
    }
    
    public static int lottoPaymentPriceInput(String input) throws IllegalArgumentException {
        checkLottoPaymentPriceInputAllException(input);
        return Integer.parseInt(input);
    }
    
    private static void checkLottoPaymentPriceInputAllException(String input) throws IllegalArgumentException {
        checkNullException(input);
        checkLottoPaymentPriceInputFormatException(input);
    }
    
    private static void checkLottoPaymentPriceInputFormatException(String input) throws IllegalArgumentException {
        Matcher matcher = Pattern.compile(LOTTO_PAYMENT_PRICE_INPUT_FORM).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void checkNullException(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    public static WinningLottoNumbers winningLottoNumbersInput() throws IllegalArgumentException {
        try {
            System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
            return winningLottoNumbersInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningLottoNumbersInput();
        }
    }
    
    public static WinningLottoNumbers winningLottoNumbersInput(String input) throws IllegalArgumentException {
        checkWinningLottoNumbersInputAllException(input);
        return new WinningLottoNumbers(getLottoNumbers(removeSpace(input)));
    }
    
    private static void checkWinningLottoNumbersInputAllException(String input) throws IllegalArgumentException {
        checkNullException(input);
        checkWinningLottoNumbersInputFormatException(removeSpace(input));
    }
    
    private static void checkWinningLottoNumbersInputFormatException(String input) throws IllegalArgumentException {
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
}
