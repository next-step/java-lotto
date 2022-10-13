package lotto.step2.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentInformation {
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    private static final String LOTTO_PAYMENT_PRICE_INPUT_FORM = "[1-9][0-9]*000";
    private static final int TICKET_PRICE = 1000;
    
    private final int paymentPrice;
    private int countOfManualLotto;
    
    public PaymentInformation(String paymentPrice) {
        this.paymentPrice = checkLottoPaymentPriceInputFormatException(paymentPrice);
    }
    
    private int checkLottoPaymentPriceInputFormatException(String paymentPrice) {
        Matcher matcher = Pattern.compile(LOTTO_PAYMENT_PRICE_INPUT_FORM).matcher(paymentPrice);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
        return Integer.parseInt(paymentPrice);
    }
    
    public void inputCountOfManualLotto(final String inputCountOfManualLotto) {
        countOfManualLotto = checkCountOfManualLottoInputForm(inputCountOfManualLotto);
        checkCountOfManualLottoIsExceeded(countOfManualLotto);
    }
    
    private void checkCountOfManualLottoIsExceeded(final int countOfManualLotto) {
        if (countOfManualLotto * TICKET_PRICE > paymentPrice) {
            throw new IllegalArgumentException("로또 개수를 초과하였습니다. 다시 입력해주세요.");
        }
    }
    
    private int checkCountOfManualLottoInputForm(final String inputCountOfManualLotto) {
        final Matcher matcher = Pattern.compile("[0-9]+").matcher(inputCountOfManualLotto);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
        
        return Integer.parseInt(inputCountOfManualLotto);
    }
    
    public int countOfAutoLotto() {
        return (this.paymentPrice - TICKET_PRICE * countOfManualLotto) / TICKET_PRICE;
    }
    
    public int countOfManualLotto() {
        return countOfManualLotto;
    }
    
    public int getPaymentPrice() {
        return paymentPrice;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentInformation that = (PaymentInformation) o;
        return paymentPrice == that.paymentPrice;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(paymentPrice);
    }
}
