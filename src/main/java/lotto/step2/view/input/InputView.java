package lotto.step2.view.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    
    public static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    public static final String LOTTO_PAYMENT_INPUT_FORM = "[1-9][0-9]*000";
    
    public static int lottoPaymentInput(String input) throws IllegalArgumentException {
        checkAllLottoPaymentInputException(input);
        return Integer.parseInt(input);
    }
    
    private static void checkAllLottoPaymentInputException(String input) throws IllegalArgumentException {
        checkNullException(input);
        checkLottoPaymentInputFormatException(input);
    }
    
    private static void checkLottoPaymentInputFormatException(String input) throws IllegalArgumentException {
        Matcher matcher = Pattern.compile(LOTTO_PAYMENT_INPUT_FORM).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void checkNullException(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
