package lotto.domain.exception;

public class InvalidLottoShopManualCountException extends LottoException {
    private static final String INVALID_LOTTO_SHOP_MANUAL_COUNT_MESSAGE = "수동 로또의 갯수는 0 이상이며 구매 가능한 갯수여야 합니다.";

    public InvalidLottoShopManualCountException(String... messages) {
        super(INVALID_LOTTO_SHOP_MANUAL_COUNT_MESSAGE, messages);
    }
}
