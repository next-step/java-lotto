package lottoauto.utils;

public class ValidationUtils {

    private static final int ONE_LOTTO_AMOUNT = 1000;

    public static int amountValidateForQuantity(int amount) {
        if (amount < ONE_LOTTO_AMOUNT) {
            throw new IllegalArgumentException("로또 한개의 금액은 1000원 입니다.");
        }

        return amount / ONE_LOTTO_AMOUNT;
    }
}
