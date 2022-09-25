package lotto.step2.view.input;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.WinningLottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    private static final String LOTTO_PAYMENT_PRICE_INPUT_FORM = "[1-9][0-9]*000";
    private static final String LOTTO_PAYMENT_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    
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
        checkAllLottoPaymentPriceInputException(input);
        return Integer.parseInt(input);
    }
    
    private static void checkAllLottoPaymentPriceInputException(String input) throws IllegalArgumentException {
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
    
    public static WinningLottoNumbers winningLottoNumbersInput(String input) {
        return new WinningLottoNumbers(getLottoNumbers(removeSpace(input)));
    }
    
    private static String removeSpace(String input) {
        return input.replace(" ", "");
    }
    
    private static List<LottoNumber> getLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
