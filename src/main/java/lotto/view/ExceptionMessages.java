package lotto.view;

public class ExceptionMessages {

    private ExceptionMessages() {
    }

    public static final String LOTTO_NUMBER_MUST_BE_BETWEEN_1_AND_45 = "로또 번호는 1부터 45까지의 수만 가능합니다.";
    public static final String LOTTO_NUMBERS_MUST_BE_6_TOTAL = "로또 번호는 6개여야만 합니다.";
    public static final String THERE_ARE_DUPLICATE_NUMBERS = "중복된 번호가 존재합니다.";
    public static final String AMOUNT_SMALLER_THAN_ZERO = "0보다 작은 금액은 존재할 수 없습니다.";
    public static final String AT_LEAST_ONE_LOTTO_TICKET = "1개 이상의 LottoTicket이 핊요합니다.";
}
