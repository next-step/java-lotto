package lotto.domain;

public class LottoTicketManual {

    private static final int BASE_NUMBER = 0;
    private static final String PURCHASE_LOTTO_PRICE_ERROR_MESSAGE = "로또 수는 구입 금액 범위 안에서 입력해주세요.";
    private static final String NEGATIVE_LOTTO_COUNT_ERROR_MESSAGE = "수동으로 구매할 로또 수는 음수일 수 없습니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "수동으로 입력할 수 있는 로또 수는 정수만 작성할 수 있습니다.";
    private final int value;

    public LottoTicketManual(final String value, final int count) {
        int convertIntValue = validateTypeInput(value);
        validateNegativeNumber(convertIntValue);
        validatePurchaseLottoTicketMax(convertIntValue, count);
        this.value = convertIntValue;
    }

    public LottoTicketManual(LottoCalculation lottoCalculation, String inputLottoTicket) {
        this(inputLottoTicket, lottoCalculation.getLottosCalculation());
    }

    private void validatePurchaseLottoTicketMax(final int value, final int count) {
        if (value > count) {
            throw new IllegalArgumentException(PURCHASE_LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    private void validateNegativeNumber(final int value) {
        if (value < BASE_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private int validateTypeInput(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public int getLottoTicketValue() {
        return value;
    }
}
